package com.plserver.hazelcast.client.test;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.config.Config;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.ITopic;

public class Main {
	static HazelcastInstance hcclient;
	final static String cellInfoTopic = "CellInfoTopic";
	
	public static void main(String[] args) throws InterruptedException {
		Hazelcast.newHazelcastInstance();
		hcclient = HazelcastClient.newHazelcastClient();
		ITopic<String> topic = hcclient.getTopic (cellInfoTopic);
		CellEventListener cellEventListener = new CellEventListener(hcclient);
		topic.addMessageListener(cellEventListener);
		for (int i=0; i<200; i++) {
			topic.publish(new String("some string"));
//			Thread.sleep(50);// TODO if uncomment it stops to hang up.
		}
		// BUG!!!: we will never be here because publish() hangs up.
		System.out.println("EXIT");
	}
}
