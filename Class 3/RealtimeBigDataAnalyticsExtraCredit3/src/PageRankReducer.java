import java.io.IOException;
import java.util.Iterator;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;

public class PageRankReducer extends MapReduceBase implements Reducer<Text, Text, Text, Text> {

public void reduce(Text key, Iterator<Text> values,
		OutputCollector<Text, Text> output, Reporter reporter) throws IOException {
	
	String k = key.toString();
	k = k.split("=")[1];
	String pointsTo = "";
	double cnt = 0;
	while (values.hasNext()) {
		String t = values.next().toString();
		System.out.println(t);
		String [] arr = t.split(", ");
		
		if(arr.length==1){
			pointsTo += arr[0].split("=")[1];
		}
		else{
			cnt += Double.parseDouble(arr[1].trim());
		}
	}
	output.collect(new Text(k.split(",")[0].trim()), new Text(pointsTo.trim() + " " + cnt));
}
}