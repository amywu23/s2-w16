import org.jfree.chart.*;
import org.jfree.chart.plot.*;
import org.jfree.data.category.*; 
import org.jfree.ui.*; 
import java.util.*;

public class BarChartDemographics extends ApplicationFrame {
  //LOOK HERE
  private ImportData id = new ImportData("https://think.cs.vt.edu/corgis/datasets/csv/county_demographics/county_demographics.csv");
  
  //STUDY THIS
  public BarChartDemographics() {
      super( "Califor Demographics" );        
      JFreeChart barChart = ChartFactory.createBarChart(
         "# of Households in California Counties with more than 25% of seniors (aged 65+)",           
         "",            
         "Number of Households",            
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
         String county = r.getValueByIndex(0);
         String state = r.getValueByIndex(1);
         
         int household = Integer.parseInt(r.getValueByIndex(17));
         double olderThan65 = Double.parseDouble(r.getValueByIndex(2));

         if(state.equals("CA") && olderThan65 >= 25){
            dataset.addValue(household, county, state);
         }

      }
      return dataset; 
   }

   public static void main(String[] args) {
      new BarChartDemographics();
   }
}
