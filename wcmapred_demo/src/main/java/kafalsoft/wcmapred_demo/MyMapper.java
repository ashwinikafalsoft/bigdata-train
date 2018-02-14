package kafalsoft.wcmapred_demo;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class MyMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
	private final static IntWritable one = new IntWritable(1);
	private Text word = new Text();
	
	public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
		//String words[] = value.toString().split(" ");
		
		StringTokenizer line = new StringTokenizer(value.toString());
		while(line.hasMoreTokens()){
			word.set(line.nextToken());
			context.write(word, one);
		}
		
	}
}