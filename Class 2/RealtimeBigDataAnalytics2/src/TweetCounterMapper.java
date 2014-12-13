import java.io.IOException;

import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;

public class TweetCounterMapper extends MapReduceBase implements Mapper<LongWritable, Text, Text, IntWritable> {
public void map(LongWritable key, Text value,
OutputCollector<Text, IntWritable> output, Reporter reporter)
throws IOException {
	
String [] wordsToCheck = { "Chicago", "Dec", "Java", "hackathon"};
String line = value.toString();

line = StringUtils.lowerCase(line);

for (int i =0; i< wordsToCheck.length; i++){
	int count = StringUtils.countMatches(line, wordsToCheck[i].toLowerCase());
	output.collect(new Text(wordsToCheck[i]), new IntWritable(count));
}

}
}