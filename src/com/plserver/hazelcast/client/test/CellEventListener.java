package com.plserver.hazelcast.client.test;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IQueue;
import com.hazelcast.core.Message;
import com.hazelcast.core.MessageListener;

public class CellEventListener implements MessageListener<String> {

	// Currently, the naming and the concepts are a little imperfect
	// but let's go with it for the moment
	
	private HazelcastInstance hcclient;
	//private String userId = "";
	final static String queueName = "queueName";
	int i = 0;
	
	public CellEventListener(HazelcastInstance hcclient) {
		this.hcclient = hcclient;
	}

	@Override
	public void onMessage(Message<String> msg) {
		System.out.println(i);
		i++;
		System.out.println("BEFORE");
		IQueue<Object> q = hcclient.getQueue(queueName);
		System.out.println("AFTER");
	}	
}