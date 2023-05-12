import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import java.util.*;
 
public class PieChartDemographics extends ApplicationFrame {
   private static ImportData id = new ImportData("https://think.cs.vt.edu/corgis/datasets/csv/county_demographics/county_demographics.csv");

   public PieChartDemographics( String title ) {
      super( "Demographics" ); 
      setContentPane(createDemoPanel( ));
   }
   
   private static PieDataset createDataset( ArrayList<Record> records) {
      DefaultPieDataset dataset = new DefaultPieDataset( );
      for(Record r : records){
      
         String county = r.getValueByIndex(0);
         String state = r.getValueByIndex(1);
     
         double AmericaIndianAndAlaskaNative = Double.parseDouble(r.getValueByIndex(8));
         double Asian = Double.parseDouble(r.getValueByIndex(9));
         double Black = Double.parseDouble(r.getValueByIndex(10));
         double HispanicOrLatino = Double.parseDouble(r.getValueByIndex(11));
         double NativeHawaiianAndOtherPacificIslander = Double.parseDouble(r.getValueByIndex(12));
         double TwoOrMoreRaces = Double.parseDouble(r.getValueByIndex(13));
         double White = Double.parseDouble(r.getValueByIndex(14));


        if (county.equals("Alameda County") && state.equals("CA")){
            dataset.setValue( "AmericaIndianAndAlaskaNative" , AmericaIndianAndAlaskaNative );  
            dataset.setValue( "Asian" , Asian );   
            dataset.setValue( "Black" , Black );    
            dataset.setValue( "HispanicOrLatino" ,HispanicOrLatino); 
            dataset.setValue( "NativeHawaiianAndOtherPacificIslander" , NativeHawaiianAndOtherPacificIslander );  
            dataset.setValue( "TwoOrMoreRaces" , TwoOrMoreRaces );   
            dataset.setValue( "White" , White );    
             } }
         
            return dataset;        
   }
   
   private static JFreeChart createChart( PieDataset dataset ) {
      JFreeChart chart = ChartFactory.createPieChart(      
         "Alameda County Population by Race",   // chart title 
         dataset,          // data    
         true,             // include legend   
         true, 
         false);

      return chart;
   }
   
   public static JPanel createDemoPanel( ) {
      JFreeChart chart = createChart(createDataset(id.getData()));  
      return new ChartPanel( chart ); 
   }

   public static void main( String[ ] args ) {
      PieChartDemographics demo = new PieChartDemographics( "Alameda County Population" );  
      demo.setSize( 560 , 367 );    
      RefineryUtilities.centerFrameOnScreen( demo );    
      demo.setVisible( true ); 
   }
}
