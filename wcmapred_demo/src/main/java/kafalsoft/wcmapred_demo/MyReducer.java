package kafalsoft.wcmapred_demo;

import java.io.IOException;

import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;


public class MyReducer extends Reducer<Text, IntWritable, Text, IntWritable> {
	
	public void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException,InterruptedException {
		int sum = 0;
		
		while (values.iterator().hasNext()){
			sum = sum + values.iterator().next().get();
		}
		
		context.write(key, new IntWritable(sum));
		
	}
	
}