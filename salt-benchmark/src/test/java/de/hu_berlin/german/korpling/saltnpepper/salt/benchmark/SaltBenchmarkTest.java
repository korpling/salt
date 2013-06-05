/*
 * Copyright 2013 Humboldt Univerity of Berlin, INRIA.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.hu_berlin.german.korpling.saltnpepper.salt.benchmark;

import com.carrotsearch.junitbenchmarks.BenchmarkOptions;
import com.carrotsearch.junitbenchmarks.BenchmarkRule;
import com.carrotsearch.junitbenchmarks.annotation.AxisRange;
import com.carrotsearch.junitbenchmarks.annotation.BenchmarkHistoryChart;
import com.carrotsearch.junitbenchmarks.annotation.BenchmarkMethodChart;
import com.carrotsearch.junitbenchmarks.annotation.LabelType;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.GraphFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Label;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Node;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.impl.GraphImpl;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.CentralIndex;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;

/**
 *
 * @author Thomas Krause <thomas.krause@alumni.hu-berlin.de>
 */
@BenchmarkOptions(callgc = false, benchmarkRounds = 5, warmupRounds = 5)
@BenchmarkMethodChart(filePrefix = "salt-benchmark")
@BenchmarkHistoryChart(labelWith = LabelType.RUN_ID, maxRuns = 20)
@AxisRange(min=0.0)
public class SaltBenchmarkTest
{
  
  @Rule
  public TestRule benchmarkRun = new BenchmarkRule();
  
  public SaltBenchmarkTest()
  {
  }
  
  @BeforeClass
  public static void setUpClass()
  {
  }
  
  @AfterClass
  public static void tearDownClass()
  {
  }
  
  @Before
  public void setUp()
  {
  }
  
  @After
  public void tearDown()
  {
  }
  
   @Test
   public void addNodesWithLabels() throws Exception {
     
     Graph g = GraphFactory.eINSTANCE.createGraph();
        
     for(int i=0; i < 20000; i++)
     {
        Node n =  GraphFactory.eINSTANCE.createNode();
        n.setId("" + i);
        
        g.addNode(n);
        
        for(int l=0; l < 20; l++)
        {
          Label lbl = GraphFactory.eINSTANCE.createLabel();
          lbl.setName("lbl" + l);
          lbl.setNamespace("salt");
          lbl.setValue("lblValue "+ l + i);
          n.addLabel(lbl);
        }
     }
     
     int count = 0;
     for(Node n : g.getNodes())
     {
       // get any label
       int lblNr = (int) (Math.random() * 19.0);
       Label l = n.getLabel("salt", "lbl" + lblNr);
       if(l != null)
       {
         count++;
       }
     }
     Assert.assertEquals(20000, count);
   }
   
   @Test
   public void addNodesWithLabelsIndex() throws Exception {
     
     final String IDXNAME = "labelqname";
     
     GraphImpl g = (GraphImpl) GraphFactory.eINSTANCE.createGraph();
     
     CentralIndex index = g.getCentralIndex();
     index.addIndex(IDXNAME, String.class, Label.class);
     
     for(int i=0; i < 20000; i++)
     {
        Node n =  GraphFactory.eINSTANCE.createNode();
        n.setId("" + i);
        
        g.addNode(n);
        
        for(int l=0; l < 20; l++)
        {
          Label lbl = GraphFactory.eINSTANCE.createLabel();
          lbl.setName("lbl" + l);
          lbl.setNamespace("salt");
          lbl.setValue("lblValue "+ l + i);
          n.addLabel(lbl);
          index.put(IDXNAME, n.getId() + "_label_" + lbl.getQName(), lbl);
        }
     }
     
     int count = 0;
    
     for(Node n : g.getNodes())
     {
       // get any label
       int lblNr = (int) (Math.random() * 19.0);
       Label l = index.get(IDXNAME, n.getId() + "_label_" + "salt::lbl" + lblNr);
       if(l != null)
       {
         count++;
       }
     }
     Assert.assertEquals(20000, count);
   }
   
}