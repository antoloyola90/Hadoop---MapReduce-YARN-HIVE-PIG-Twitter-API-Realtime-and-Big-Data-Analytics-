import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.FileInputFormat;
import org.apache.hadoop.mapred.FileOutputFormat;
import org.apache.hadoop.mapred.JobClient;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapreduce.Job;

public class PageRank {
public static void main(String[] args) throws IOException, InterruptedException {
if (args.length != 2) {
System.err.println("Usage: TweetCounter <input path> <output path>");
System.exit(-1);
}

JobConf conf = new JobConf(PageRank.class);
conf.setJobName("Page Rank Extra Credit 1");
FileInputFormat.addInputPath(conf, new Path(args[0]));
FileOutputFormat.setOutputPath(conf, new Path(args[1]));
conf.setMapperClass(PageRankMapper.class);
conf.setReducerClass(PageRankReducer.class);
conf.setOutputKeyClass(Text.class);
conf.setOutputValueClass(Text.class);
JobClient.runJob(conf).waitForCompletion();	


JobConf conf1 = new JobConf(PageRank.class);
conf1.setJobName("Page Rank Extra Credit 2");
FileInputFormat.addInputPath(conf1, new Path("./src/output/part-00000"));
FileOutputFormat.setOutputPath(conf1, new Path("./src/output1"));
conf1.setMapperClass(PageRankMapper.class);
conf1.setReducerClass(PageRankReducer.class);
conf1.setOutputKeyClass(Text.class);
conf1.setOutputValueClass(Text.class);
JobClient.runJob(conf1).waitForCompletion();	

JobConf conf2 = new JobConf(PageRank.class);
conf2.setJobName("Page Rank Extra Credit 3");
FileInputFormat.addInputPath(conf2, new Path("./src/output1/part-00000"));
FileOutputFormat.setOutputPath(conf2, new Path("./src/output2"));
conf2.setMapperClass(PageRankMapper.class);
conf2.setReducerClass(PageRankReducer.class);
conf2.setOutputKeyClass(Text.class);
conf2.setOutputValueClass(Text.class);
JobClient.runJob(conf2).waitForCompletion();	

}
}
