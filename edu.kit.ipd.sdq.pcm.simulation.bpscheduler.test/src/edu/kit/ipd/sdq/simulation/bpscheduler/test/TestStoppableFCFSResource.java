package edu.kit.ipd.sdq.simulation.bpscheduler.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import org.junit.Before;
import org.junit.Test;

import de.uka.ipd.sdq.scheduler.IActiveResource;
import de.uka.ipd.sdq.scheduler.ISchedulableProcess;
import de.uka.ipd.sdq.scheduler.SchedulerModel;
import de.uka.ipd.sdq.simulation.abstractsimengine.AbstractSimEventDelegator;
import de.uka.ipd.sdq.simulation.abstractsimengine.AbstractSimProcessDelegator;
import de.uka.ipd.sdq.simulation.abstractsimengine.ISimEngineFactory;
import de.uka.ipd.sdq.simulation.abstractsimengine.ISimulationConfig;
import de.uka.ipd.sdq.simulation.abstractsimengine.ISimulationControl;
import de.uka.ipd.sdq.simulation.abstractsimengine.ISimulationModel;
import de.uka.ipd.sdq.simulation.abstractsimengine.desmoj.DesmoJSimEngineFactory;
import edu.kit.ipd.sdq.pcm.simulation.bpscheduler.ISuspendableSchedulableProcess;
import edu.kit.ipd.sdq.pcm.simulation.bpscheduler.SuspendableFCFSResource;
import edu.kit.ipd.sdq.simulation.bpscheduler.test.TestStoppableFCFSResource.Bookkeeping.Type;

public class TestStoppableFCFSResource {

    private SchedulerModel model;

    private Bookkeeping bookkeeping;

    @Before
    public void setup() {

        // // load factory for the preferred simulation engine
        // ISimEngineFactory factory = SimulationPreferencesHelper.getPreferredSimulationEngine();
        // if (factory == null) {
        // throw new
        // RuntimeException("There is no simulation engine available. Install at least one engine.");
        // }

        ISimEngineFactory factory = new DesmoJSimEngineFactory();

        // create and return simulation model
        model = new MockupSchedulerModel(new MockupConfig(), factory);

        bookkeeping = new Bookkeeping();

        // return model;
        //
        // model = new MockupSchedulerModel();
        // DesmoJSimEngineFactory f = new DesmoJSimEngineFactory();
        // model.setSimulationEngineFactory(f);
        // f.setModel(model);

        // model.getSimulationControl().
    }

    public static class Bookkeeping {

        enum Type {
            STARTED_LIFECYCLE, ACTIVATED, PASSIVATED, FINISHED
        }

        private List<Entry> entryList;

        public Bookkeeping() {
            this.entryList = new ArrayList<Entry>();
        }

        public void addEntry(Process process, Type type, double time) {
            addEntry(process, type, time, "");
        }

        public void addEntry(Process process, Type type, double time, String metadata) {
            System.out.println(type + " " + process.getName() + " at t=" + time + " " + metadata);

            this.entryList.add(new Entry(process, type, time));
        }

        public boolean containsEntry(Process process, Type type, double time) {
            Entry e = new Entry(process, type, time);
            return entryList.contains(e);
        }

        private class Entry {

            private Process process;

            private Type type;

            private double time;

            public Entry(Process process, Type type, double time) {
                this.process = process;
                this.type = type;
                this.time = time;
            }

            public Process getProcess() {
                return process;
            }

            public Type getType() {
                return type;
            }

            @Override
            public boolean equals(Object obj) {
                // TODO
                Entry entry = (Entry) obj;
                if (entry.process == this.process && entry.type == this.type && entry.time == this.time) {
                    return true;
                }
                return false;

            }

        }

    }

//    @Test
//    public void testX() {
//        ((MockupSchedulerModel) model).setInitCommand(new ICommand() {
//
//            @Override
//            public void execute() {
//                final SuspendableFCFSResource resource = new SuspendableFCFSResource(model, 1, "TestResource", "1");
//                ((MockupSchedulerModel) model).setResource(resource);
//                resource.suspend();
//
//                final Process processA = new Process(model, "processA", 10, false);
//                final Process processB = new Process(model, "processB", 10, false);
//                final Process processC = new Process(model, "processC", 10, false);
//                final Process processD = new Process(model, "processD", 20, false);
//
//                processA.scheduleAt(10);
//                processB.scheduleAt(10);
//                processC.scheduleAt(10);
//                processD.scheduleAt(30);
//
//                new ResumeEvent(model, "Resume").schedule(resource, 20);
//                new SuspendEvent(model, "Suspend").schedule(resource, 25);
//                new ResumeEvent(model, "Resume").schedule(resource, 40);
//                new StopEvent(model, "Stop").schedule(resource, 100);
//
//                ((MockupSchedulerModel) model).setFinaliseCommand(new ICommand() {
//
//                    @Override
//                    public void execute() {
//                        Assert.assertTrue(bookkeeping.containsEntry(processA, Type.STARTED_LIFECYCLE, 10));
//                        Assert.assertTrue(bookkeeping.containsEntry(processB, Type.STARTED_LIFECYCLE, 10));
//                        Assert.assertTrue(bookkeeping.containsEntry(processC, Type.STARTED_LIFECYCLE, 10));
//                        Assert.assertTrue(bookkeeping.containsEntry(processD, Type.STARTED_LIFECYCLE, 30));
//
//                        // (Resource still in suspended mode)
//
//                        Assert.assertTrue(bookkeeping.containsEntry(processA, Type.ACTIVATED, 30));
//                        Assert.assertEquals(0.0, resource.getRemainingDemand(processA));
//
//                        Assert.assertTrue(bookkeeping.containsEntry(processB, Type.ACTIVATED, 50));
//                        Assert.assertEquals(0.0, resource.getRemainingDemand(processB));
//
//                        Assert.assertTrue(bookkeeping.containsEntry(processC, Type.ACTIVATED, 60));
//                        Assert.assertEquals(0.0, resource.getRemainingDemand(processC));
//
//                        Assert.assertTrue(bookkeeping.containsEntry(processD, Type.ACTIVATED, 80));
//                        Assert.assertEquals(0.0, resource.getRemainingDemand(processD));
//                    }
//
//                });
//
//            }
//
//        });
//
//        model.getSimulationControl().start();
//    }

    // public void test(ICommand initCommand, ICommand finaliseCommand) {
    // ((MockupSchedulerModel) model).setInitCommand(initCommand);
    // ((MockupSchedulerModel) model).setInitCommand(initCommand);
    // }

    @Test
    public void testOne() {
        ((MockupSchedulerModel) model).setInitCommand(new ICommand() {

            @Override
            public void execute() {
                final SuspendableFCFSResource resource = new SuspendableFCFSResource(model, 1, "TestResource", "1");
                ((MockupSchedulerModel) model).setResource(resource);
                resource.suspend();

                final Process pI = new Process(model, "processI", 10, true);
                final Process pNI = new Process(model, "processNI", 10, false);

                pI.scheduleAt(0);
                pNI.scheduleAt(10);

                new ResumeEvent(model, "Resume").schedule(resource, 10);
                new StopEvent(model, "Stop").schedule(resource, 40);

                ((MockupSchedulerModel) model).setFinaliseCommand(new ICommand() {

                    @Override
                    public void execute() {
                        Assert.assertTrue(bookkeeping.containsEntry(pNI, Type.ACTIVATED, 20));
                        Assert.assertEquals(0.0, resource.getRemainingDemand(pNI));

                        Assert.assertTrue(bookkeeping.containsEntry(pI, Type.ACTIVATED, 30));
                        Assert.assertEquals(0.0, resource.getRemainingDemand(pI));
                    }

                });

            }

        });

        model.getSimulationControl().start();
    }

    @Test
    public void testTwo() {
        ((MockupSchedulerModel) model).setInitCommand(new ICommand() {

            @Override
            public void execute() {
                final SuspendableFCFSResource resource = new SuspendableFCFSResource(model, 1, "TestResource", "1");
                ((MockupSchedulerModel) model).setResource(resource);
                resource.suspend();

                final Process pI = new Process(model, "processI", 10, true);
                final Process pNI = new Process(model, "processNI", 10, false);

                pNI.scheduleAt(0);
                pI.scheduleAt(10);

                new ResumeEvent(model, "Resume").schedule(resource, 10);
                new StopEvent(model, "Stop").schedule(resource, 40);

                ((MockupSchedulerModel) model).setFinaliseCommand(new ICommand() {

                    @Override
                    public void execute() {
                        Assert.assertTrue(bookkeeping.containsEntry(pNI, Type.ACTIVATED, 20));
                        Assert.assertEquals(0.0, resource.getRemainingDemand(pNI));

                        Assert.assertTrue(bookkeeping.containsEntry(pI, Type.ACTIVATED, 30));
                        Assert.assertEquals(0.0, resource.getRemainingDemand(pI));
                    }

                });

            }

        });

        model.getSimulationControl().start();
    }

    @Test
    public void testThree() {
        ((MockupSchedulerModel) model).setInitCommand(new ICommand() {

            @Override
            public void execute() {
                final SuspendableFCFSResource resource = new SuspendableFCFSResource(model, 1, "TestResource", "1");
                ((MockupSchedulerModel) model).setResource(resource);
                resource.suspend();

                final Process pI = new Process(model, "processI", 10, true);
                final Process pNI1 = new Process(model, "processNI1", 10, false);
                final Process pNI2 = new Process(model, "processNI2", 10, false);

                pI.scheduleAt(0);
                pNI1.scheduleAt(5);
                pNI2.scheduleAt(10);

                new ResumeEvent(model, "Resume").schedule(resource, 10);
                new StopEvent(model, "Stop").schedule(resource, 50);

                ((MockupSchedulerModel) model).setFinaliseCommand(new ICommand() {

                    @Override
                    public void execute() {
                        Assert.assertTrue(bookkeeping.containsEntry(pNI1, Type.ACTIVATED, 20));
                        Assert.assertEquals(0.0, resource.getRemainingDemand(pNI1));

                        Assert.assertTrue(bookkeeping.containsEntry(pNI2, Type.ACTIVATED, 30));
                        Assert.assertEquals(0.0, resource.getRemainingDemand(pNI2));

                        Assert.assertTrue(bookkeeping.containsEntry(pI, Type.ACTIVATED, 40));
                        Assert.assertEquals(0.0, resource.getRemainingDemand(pI));
                    }

                });

            }

        });

        model.getSimulationControl().start();
    }

    @Test
    public void testFour() {
        ((MockupSchedulerModel) model).setInitCommand(new ICommand() {

            @Override
            public void execute() {
                final SuspendableFCFSResource resource = new SuspendableFCFSResource(model, 1, "TestResource", "1");
                ((MockupSchedulerModel) model).setResource(resource);
                resource.suspend();

                final Process pI = new Process(model, "processI", 10, true);
                final Process pNI1 = new Process(model, "processNI1", 10, false);
                final Process pNI2 = new Process(model, "processNI2", 10, false);

                pNI1.scheduleAt(0);
                pNI2.scheduleAt(5);
                pI.scheduleAt(10);

                new ResumeEvent(model, "Resume").schedule(resource, 10);
                new StopEvent(model, "Stop").schedule(resource, 50);

                ((MockupSchedulerModel) model).setFinaliseCommand(new ICommand() {

                    @Override
                    public void execute() {
                        Assert.assertTrue(bookkeeping.containsEntry(pNI1, Type.ACTIVATED, 20));
                        Assert.assertEquals(0.0, resource.getRemainingDemand(pNI1));

                        Assert.assertTrue(bookkeeping.containsEntry(pNI2, Type.ACTIVATED, 30));
                        Assert.assertEquals(0.0, resource.getRemainingDemand(pNI2));

                        Assert.assertTrue(bookkeeping.containsEntry(pI, Type.ACTIVATED, 40));
                        Assert.assertEquals(0.0, resource.getRemainingDemand(pI));
                    }

                });

            }

        });

        model.getSimulationControl().start();
    }

    @Test
    public void testFive() {
        ((MockupSchedulerModel) model).setInitCommand(new ICommand() {

            @Override
            public void execute() {
                final SuspendableFCFSResource resource = new SuspendableFCFSResource(model, 1, "TestResource", "1");
                ((MockupSchedulerModel) model).setResource(resource);
                resource.suspend();

                final Process pNI1 = new Process(model, "processNI1", 10, false);
                final Process pNI2 = new Process(model, "processNI2", 10, false);

                pNI1.scheduleAt(0);
                pNI2.scheduleAt(5);

                new ResumeEvent(model, "Resume").schedule(resource, 10);
                new StopEvent(model, "Stop").schedule(resource, 50);

                ((MockupSchedulerModel) model).setFinaliseCommand(new ICommand() {

                    @Override
                    public void execute() {
                        Assert.assertTrue(bookkeeping.containsEntry(pNI1, Type.ACTIVATED, 20));
                        Assert.assertEquals(0.0, resource.getRemainingDemand(pNI1));

                        Assert.assertTrue(bookkeeping.containsEntry(pNI2, Type.ACTIVATED, 30));
                        Assert.assertEquals(0.0, resource.getRemainingDemand(pNI2));
                    }

                });

            }

        });

        model.getSimulationControl().start();
    }

    @Test
    public void testSix() {
        ((MockupSchedulerModel) model).setInitCommand(new ICommand() {

            @Override
            public void execute() {
                final SuspendableFCFSResource resource = new SuspendableFCFSResource(model, 1, "TestResource", "1");
                ((MockupSchedulerModel) model).setResource(resource);
                resource.suspend();

                final Process pI1 = new Process(model, "processI1", 10, true);
                final Process pI2 = new Process(model, "processI2", 10, true);

                pI1.scheduleAt(0);
                pI2.scheduleAt(5);

                new ResumeEvent(model, "Resume").schedule(resource, 10);
                new StopEvent(model, "Stop").schedule(resource, 50);

                ((MockupSchedulerModel) model).setFinaliseCommand(new ICommand() {

                    @Override
                    public void execute() {
                        Assert.assertTrue(bookkeeping.containsEntry(pI1, Type.ACTIVATED, 20));
                        Assert.assertEquals(0.0, resource.getRemainingDemand(pI1));

                        Assert.assertTrue(bookkeeping.containsEntry(pI2, Type.ACTIVATED, 30));
                        Assert.assertEquals(0.0, resource.getRemainingDemand(pI2));
                    }

                });

            }

        });

        model.getSimulationControl().start();
    }

    @Test
    public void testSeven() {
        ((MockupSchedulerModel) model).setInitCommand(new ICommand() {

            @Override
            public void execute() {
                final SuspendableFCFSResource resource = new SuspendableFCFSResource(model, 1, "TestResource", "1");
                ((MockupSchedulerModel) model).setResource(resource);
                resource.suspend();

                final Process pI = new Process(model, "processI", 10, true);
                final Process pNI = new Process(model, "processNI", 10, false);

                pI.scheduleAt(10);
                pNI.scheduleAt(15);

                new ResumeEvent(model, "Resume").schedule(resource, 10);
                new StopEvent(model, "Stop").schedule(resource, 50);

                ((MockupSchedulerModel) model).setFinaliseCommand(new ICommand() {

                    @Override
                    public void execute() {
                        Assert.assertTrue(bookkeeping.containsEntry(pNI, Type.ACTIVATED, 25));
                        Assert.assertEquals(0.0, resource.getRemainingDemand(pNI));

                        Assert.assertTrue(bookkeeping.containsEntry(pI, Type.ACTIVATED, 30));
                        Assert.assertEquals(0.0, resource.getRemainingDemand(pI));
                    }

                });

            }

        });

        model.getSimulationControl().start();
    }

    @Test
    public void testEight() {
        ((MockupSchedulerModel) model).setInitCommand(new ICommand() {

            @Override
            public void execute() {
                final SuspendableFCFSResource resource = new SuspendableFCFSResource(model, 1, "TestResource", "1");
                ((MockupSchedulerModel) model).setResource(resource);
                resource.suspend();

                final Process pI = new Process(model, "processI", 10, true);
                final Process pNI = new Process(model, "processNI", 10, false);

                pNI.scheduleAt(10);
                pI.scheduleAt(15);

                new ResumeEvent(model, "Resume").schedule(resource, 10);
                new StopEvent(model, "Stop").schedule(resource, 50);

                ((MockupSchedulerModel) model).setFinaliseCommand(new ICommand() {

                    @Override
                    public void execute() {
                        
                        //   t: 0         10   15   20        30
                        //...............................................
                        //  pI:                [\\\\\----10---]
                        // pNI:           [----10---]
                        
                        Assert.assertTrue(bookkeeping.containsEntry(pNI, Type.ACTIVATED, 20));
                        Assert.assertEquals(0.0, resource.getRemainingDemand(pNI));

                        Assert.assertTrue(bookkeeping.containsEntry(pI, Type.ACTIVATED, 30));
                        Assert.assertEquals(0.0, resource.getRemainingDemand(pI));
                    }

                });

            }

        });

        model.getSimulationControl().start();
    }
    
    @Test
    public void testNine() {
        ((MockupSchedulerModel) model).setInitCommand(new ICommand() {

            @Override
            public void execute() {
                final SuspendableFCFSResource resource = new SuspendableFCFSResource(model, 1, "TestResource", "1");
                ((MockupSchedulerModel) model).setResource(resource);
                resource.suspend();

                final Process pI = new Process(model, "processI", 10, true);

                pI.scheduleAt(10);

                new ResumeEvent(model, "Resume").schedule(resource, 10);
                new SuspendEvent(model, "Suspend").schedule(resource, 15);
                new ResumeEvent(model, "Resume").schedule(resource, 20);
                new StopEvent(model, "Stop").schedule(resource, 50);

                ((MockupSchedulerModel) model).setFinaliseCommand(new ICommand() {

                    @Override
                    public void execute() {

                        //      S         R     S   R
                        //   t: 0         10   15   20   25   30
                        //...............................................
                        //  pI:           [--5--\\\\\-5--]
                        
                        Assert.assertTrue(bookkeeping.containsEntry(pI, Type.ACTIVATED, 25));
                        Assert.assertEquals(0.0, resource.getRemainingDemand(pI));
                        
                    }

                });

            }

        });

        model.getSimulationControl().start();
    }
    
    @Test
    public void testTen() {
        ((MockupSchedulerModel) model).setInitCommand(new ICommand() {

            @Override
            public void execute() {
                final SuspendableFCFSResource resource = new SuspendableFCFSResource(model, 1, "TestResource", "1");
                ((MockupSchedulerModel) model).setResource(resource);
                resource.suspend();

                
                final Process pNI1 = new Process(model, "processNI1", 10, false);
                final Process pNI2 = new Process(model, "processNI2", 10, false);
                final Process pI1 = new Process(model, "processI1", 10, true);
                final Process pI2 = new Process(model, "processI2", 10, true);

                pNI1.scheduleAt(10);
                pNI2.scheduleAt(11);
                pI1.scheduleAt(10);
                pI2.scheduleAt(11);

                new ResumeEvent(model, "Resume").schedule(resource, 10);
                new SuspendEvent(model, "Suspend").schedule(resource, 15);
                new ResumeEvent(model, "Resume").schedule(resource, 25);
                
                new SuspendEvent(model, "Suspend").schedule(resource, 45);
                new ResumeEvent(model, "Resume").schedule(resource, 55);
                
                new StopEvent(model, "Stop").schedule(resource, 100);

                ((MockupSchedulerModel) model).setFinaliseCommand(new ICommand() {

                    @Override
                    public void execute() {
                        
                        //      S         R    S         R
                        //   t: 0         10   15   20   25   30
                        //...............................................
                        //  pNI1:         [----10---]
                        //  pNI2:          [/////////----10---]
                        //  pI1:            [//////////////////----10---]
                        
                        Assert.assertTrue(bookkeeping.containsEntry(pNI1, Type.ACTIVATED, 20));
                        Assert.assertEquals(0.0, resource.getRemainingDemand(pNI1));
                        
                        Assert.assertTrue(bookkeeping.containsEntry(pNI2, Type.ACTIVATED, 30));
                        Assert.assertEquals(0.0, resource.getRemainingDemand(pNI1));
                        
                        Assert.assertTrue(bookkeeping.containsEntry(pI1, Type.ACTIVATED, 40));
                        Assert.assertEquals(0.0, resource.getRemainingDemand(pI1));
                        
                        Assert.assertTrue(bookkeeping.containsEntry(pI2, Type.ACTIVATED, 60));
                        Assert.assertEquals(0.0, resource.getRemainingDemand(pI2));
                        
                    }

                });

            }

        });

        model.getSimulationControl().start();
    }
    
    @Test
    public void testEleven() {
        ((MockupSchedulerModel) model).setInitCommand(new ICommand() {

            @Override
            public void execute() {
                final SuspendableFCFSResource resource = new SuspendableFCFSResource(model, 1, "TestResource", "1");
                ((MockupSchedulerModel) model).setResource(resource);
                resource.suspend();

                
                final Process pNI1 = new Process(model, "processNI1", 10, false);
                final Process pNI2 = new Process(model, "processNI2", 10, false);
                
                pNI1.scheduleAt(10);
                pNI2.scheduleAt(25);
                

                new ResumeEvent(model, "Resume").schedule(resource, 10);
                new SuspendEvent(model, "Suspend").schedule(resource, 15);
                new ResumeEvent(model, "Resume").schedule(resource, 25);
                
                
                new StopEvent(model, "Stop").schedule(resource, 100);

                ((MockupSchedulerModel) model).setFinaliseCommand(new ICommand() {

                    @Override
                    public void execute() {
                        
                        //      S         R    S         R
                        //   t: 0         10   15   20   25   30
                        //...............................................
                        //  pNI1:         [----10---]
                        //  pNI2:                        [---10---]
                        
                        
                        Assert.assertTrue(bookkeeping.containsEntry(pNI1, Type.ACTIVATED, 20));
                        Assert.assertEquals(0.0, resource.getRemainingDemand(pNI1));
                        
                        Assert.assertTrue(bookkeeping.containsEntry(pNI2, Type.ACTIVATED, 35));
                        Assert.assertEquals(0.0, resource.getRemainingDemand(pNI2));
                        
                        
                    }

                });

            }

        });

        model.getSimulationControl().start();
    }
    

    public interface ICommand {

        void execute();

    }

    private class MockupSchedulerModel extends SchedulerModel {

        private ISimulationConfig config;

        private ISimulationControl simControl;

        private ISimEngineFactory factory;

        private SuspendableFCFSResource resource;

        private ICommand initCommand;

        private ICommand finaliseCommand;

        public ICommand getInitCommand() {
            return initCommand;
        }

        public ICommand getFinaliseCommand() {
            return finaliseCommand;
        }

        public void setInitCommand(ICommand initCommand) {
            this.initCommand = initCommand;
        }

        public void setFinaliseCommand(ICommand finaliseCommand) {
            this.finaliseCommand = finaliseCommand;
        }

        public MockupSchedulerModel(MockupConfig config, ISimEngineFactory factory) {
            this.config = config;
            this.factory = factory;

            factory.setModel(this);
        }

        public void setResource(SuspendableFCFSResource resource) {
            this.resource = resource;
        }

        public SuspendableFCFSResource getResource() {
            if (resource == null) {
                throw new IllegalStateException("Resource has not yet been set.");
            }
            return resource;
        }

        @Override
        public void finalise() {
            System.out.println("Finalise");
            if (finaliseCommand == null) {
                throw new IllegalStateException("Finalise commamnd needs to be set first");
            } else {
                finaliseCommand.execute();
            }
        }

        @Override
        public ISimulationConfig getConfiguration() {
            return config;
        }

        @Override
        public ISimEngineFactory getSimEngineFactory() {
            return factory;
        }

        @Override
        public ISimulationControl getSimulationControl() {
            if (this.simControl == null) {
                this.simControl = this.factory.createSimulationControl();
            }
            return this.simControl;
        }

        @Override
        public void init() {
            System.out.println("Init");
            if (initCommand != null) {
                initCommand.execute();
            } else {
                throw new IllegalStateException("Init command needs to be set first");
            }

        }

        @Override
        public void setSimulationControl(ISimulationControl arg0) {
            this.simControl = arg0;
        }

        @Override
        public void setSimulationEngineFactory(ISimEngineFactory arg0) {
            factory = arg0;
        }

    }

    private static class SuspendEvent extends AbstractSimEventDelegator<SuspendableFCFSResource> {

        protected SuspendEvent(ISimulationModel model, String name) {
            super(model, name);
        }

        @Override
        public void eventRoutine(SuspendableFCFSResource resource) {
            resource.suspend();
        }

    }

    private static class StopEvent extends AbstractSimEventDelegator<SuspendableFCFSResource> {

        protected StopEvent(ISimulationModel model, String name) {
            super(model, name);
        }

        @Override
        public void eventRoutine(SuspendableFCFSResource resource) {
            getModel().getSimulationControl().stop();
        }

    }

    private static class ResumeEvent extends AbstractSimEventDelegator<SuspendableFCFSResource> {

        protected ResumeEvent(ISimulationModel model, String name) {
            super(model, name);
        }

        @Override
        public void eventRoutine(SuspendableFCFSResource resource) {
            resource.resume();
        }

    }

    private class Process extends AbstractSimProcessDelegator implements ISuspendableSchedulableProcess {

        private boolean interruptable;

        private double demand;

        public Process(ISimulationModel model, String name, double demand, boolean interruptable) {
            super(model, name);
            this.demand = demand;
            this.interruptable = interruptable;
        }

        @Override
        public void lifeCycle() {
            bookkeeping.addEntry(this, Type.STARTED_LIFECYCLE, model.getSimulationControl().getCurrentSimulationTime());

            // System.out.println("Process " + getName() + " started lifecyle");

            ((MockupSchedulerModel) getModel()).getResource().process(this, 1, null, demand);
        }

        @Override
        public boolean isScheduled() {
            System.out.println("isScheduled");
            return true;
        }

        @Override
        public void reschedule(double delay) {
            System.out.println("reschedule");

        }

        @Override
        public void activate() {
            bookkeeping.addEntry(this, Type.ACTIVATED, model.getSimulationControl().getCurrentSimulationTime(),
                    "[demand=" + ((MockupSchedulerModel) model).getResource().getRemainingDemand(this) + "]");
        }

        @Override
        public void passivate() {
            bookkeeping.addEntry(this, Type.PASSIVATED, model.getSimulationControl().getCurrentSimulationTime(),
                    "[demand=" + ((MockupSchedulerModel) model).getResource().getRemainingDemand(this) + "]");
        }

        @Override
        public ISchedulableProcess getRootProcess() {
            System.out.println("getRootProcess");
            return null;
        }

        @Override
        public boolean isFinished() {
            System.out.println("isFinished");
            return false;
        }

        @Override
        public void fireTerminated() {
            System.out.println("fireTerminated");

        }

        @Override
        public void addTerminatedObserver(IActiveResource o) {
            // nothing to do
        }

        @Override
        public void removeTerminatedObserver(IActiveResource o) {
            System.out.println("removeTerminatedObserver");

        }

        @Override
        public int getPriority() {
            System.out.println("getPriority");
            return 0;
        }

        @Override
        public void setPriority(int prio) {
            System.out.println("setPriority");

        }

        @Override
        public void timeout(String timeoutFailureName) {
            System.out.println("timeout");

        }

        @Override
        public boolean isInterruptable() {
            return interruptable;
        }

        @Override
        public void setInterruptable(boolean isInterruptable) {
            interruptable = isInterruptable;
        }

    }

    private static class MockupConfig implements ISimulationConfig {
        @Override
        public String getNameExperimentRun() {
            return "Test Simulation";
        }
    }

}
