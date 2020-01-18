package com.itcast.job;

import java.util.Arrays;
import java.util.List;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.dataflow.DataflowJob;

public class MyDataflowJob implements DataflowJob<String>{
	public List<String> fetchData(ShardingContext context) {
		return Arrays.asList("1", "2", "3","4");
	}

	public void processData(ShardingContext context, List<String> data) {
		
		String shardParamter = context.getShardingParameter();
		System.out.println("分片参数："+shardParamter);
		int value = Integer.parseInt(shardParamter);
		for(int i=0;i<data.size();i++){
			
			if(i%2==value){
				System.out.println("处理数据：" + data.get(i));
			}
			
		}
		
	}
}
