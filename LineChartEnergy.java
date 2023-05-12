import org.jfree.chart.*;
import org.jfree.chart.plot.*;
import org.jfree.data.category.*; 
import org.jfree.ui.*; 
import java.util.*;

public class LineChartEnergy extends ApplicationFrame {
    private ImportData id = new ImportData("https://think.cs.vt.edu/corgis/datasets/csv/energy/energy.csv");

   public LineChartEnergy( String applicationTitle , String chartTitle ) {
      super(applicationTitle);
      JFreeChart lineChart = ChartFactory.createLineChart(
         chartTitle,
         "Years","Coal production in billion BTU",
         createDataset(id.getData()),
         PlotOrientation.VERTICAL,
         true,true,false);
         
      ChartPanel chartPanel = new ChartPanel( lineChart );
      chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
      setContentPane( chartPanel );
   }

   private CategoryDataset createDataset( ArrayList<Record> records) {
      DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
      for(Record r : records){
        String year = r.getValueByIndex(1);
        String state = r.getValueByIndex(0);
        
    
        double amount = Double.parseDouble(r.getValueByIndex(2));

            if((state.equals("Wyoming") || state.equals("West Virginia") || state.equals("Montana") || state.equals("Pennsylvania") || state.equals("Illinois")) &&(year.equals("1969") || year.equals("1979") || year.equals("1989") || year.equals("1999") || year.equals("2009") || year.equals("2019")) )
           dataset.addValue(amount, state, year);
       

     }
      return dataset;
   }
   
   public static void main( String[ ] args ) {
      LineChartEnergy chart = new LineChartEnergy(
         "Coal Production Vs Years" ,
         "Coal Production vs Years");

      chart.pack( );
      RefineryUtilities.centerFrameOnScreen( chart );
      chart.setVisible( true );
   }
}
