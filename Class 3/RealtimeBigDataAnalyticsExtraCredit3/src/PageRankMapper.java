import java.io.IOException;

import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;

public class PageRankMapper extends MapReduceBase implements Mapper<LongWritable, Text, Text, Text> {


public void map(LongWritable key, Text value, OutputCollector<Text, Text> output,
		Reporter reporter) throws IOException {
	// TODO Auto-generated method stub
	String line = value.toString().trim();
	String [] arr = line.split("[ \t]");
	String pointsTo = "";
	System.out.println(line);
	for(int i =1;i<arr.length-1;i++){
		double pr = Double.parseDouble(arr[arr.length-1].trim()) / (arr.length-2);
		System.out.println("key=" + arr[i].trim() + ", " + "value=" + arr[0].trim() + ", " + pr);
		output.collect(new Text("key=" + arr[i].trim() + ", "  ), new Text("value=" + arr[0].trim() + ", " + pr));
		pointsTo += arr[i].trim() + " ";
	}
	
	output.collect(new Text("key=" + arr[0].trim() + ", "  ), new Text("value=" + pointsTo.trim()));
}
}