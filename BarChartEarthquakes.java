import org.jfree.chart.*;
import org.jfree.chart.plot.*;
import org.jfree.data.category.*; 
import org.jfree.ui.*; 
import java.util.*;

public class BarChartEarthquakes extends ApplicationFrame {
  //LOOK HERE
  private ImportData id = new ImportData("https://think.cs.vt.edu/corgis/datasets/csv/earthquakes/earthquakes.csv");
  
  //STUDY THIS
  public BarChartEarthquakes() {
      super( "Earthquake Frequency" );        
      JFreeChart barChart = ChartFactory.createBarChart(
         "YOUR TITLE",           
         "NAME OF X-AXIS",            
         "NAME OF Y-AXIS",            
         createDataset(id.getData()),    //NOTICE THIS !      
         PlotOrientation.VERTICAL,           
         true, true, false);
      
      //HOW TO COLOR BARS
      // CategoryPlot plot = barChart.getCategoryPlot();
      // BarRenderer renderer = (BarRenderer) plot.getRenderer();

      // // set the color (r,g,b) or (r,g,b,a)
      // Color color = new Color(255, 129, 189);
      // Color color1 = new Color(150, 129, 189);
      // Color color2 = new Color(0, 129, 189);
      // renderer.setSeriesPaint(0, color);
      // renderer.setSeriesPaint(1, color1);
      // renderer.setSeriesPaint(2, color2);


      ChartPanel chartPanel = new ChartPanel( barChart );        
      chartPanel.setPreferredSize(new java.awt.Dimension( 560 , 367 ) );        
      setContentPane( chartPanel ); 
      this.pack( );          
      this.setVisible( true ); 
   }
   
   private CategoryDataset createDataset(ArrayList<Record> records) {      
      DefaultCategoryDataset dataset = new DefaultCategoryDataset( );  

      //Create a dataset --
      for(Record r : records){
         String state = r.getValueByIndex(9);
         String hour = r.getValueByIndex(13);
         String year = r.getValueByIndex(5);
         int delaysCarrier = Integer.parseInt(r.getValueByIndex(6));

         if(state.equals("California") && hour.equals("5")){
            dataset.addValue(delaysCarrier, airport, year);
         }
      }
      return dataset; 
   }

   public static void main(String[] args) {
      new BarChartEarthquakes();
   }
}
