package lab6SortedList;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class FileDecoder {
	private Message m;

	public FileDecoder(String s) {
		try{
			File f = new File(s);
			Scanner scan = new Scanner(f);
			PrintWriter print = new PrintWriter("result.txt");

			m = new Message(scan);
			m.decode();

			Object[] packets = m.getPacket();
			for(int i = 0; i < packets.length; i++) {
				print.println(packets[i]);
			}

			scan.close();
		}catch(FileNotFoundException ex) {
			System.out.println("File not found");
		}
	}

	public void print() {
		Object[] p = m.getPacket();

		for(int i = 0; i < p.length; i++) {
			System.out.println(p[i]);
		}
	}

	private class Message{
		private Packet[] packets;

		public Message(Scanner s) {
			Packet[] p = new Packet[0];
			int i = 1;
			while(s.hasNextLine()) {
				p = Arrays.copyOf(p, i);
				String something = s.nextLine();
				p[i-1] = new Packet(something);
				i++;
			}
			
			packets = p;
		}

		public Packet[] getPacket() {
			return packets;
		}

		public void decode() { //will use insertion sort
			SortedLinkedList<Packet> s = new SortedLinkedList<>();

			for(int i = 0; i < packets.length; i++) {
				s.addEntry(packets[i]);
			}

			listToArray(s);
		}

		private void listToArray(SortedLinkedList<Packet> s){
			for(int i = 0; i < packets.length; i++) {
				packets[i] = s.getEntry(i);
			}
		}

		private class Packet implements Comparable<Packet>{
			private String packetText;
			
			private Packet(String s) {
				packetText = s;
			}

			public String getPacketText() {
				return packetText;
			}

			public void setPacketText(String packetText) {
				this.packetText = packetText;
			}

			@Override
			public int compareTo(Packet p) {
				//Idea the numbers of each packet will be compared by subtracting the two number variables
				//negative means this packet is smaller
				//0 means the numbers are the same
				//positive means this packet is bigger
				
				int comparison = (int) getPacketText().charAt(0) - (int) p.getPacketText().charAt(0);

				if(comparison < 0) {
					return -1;
				} else if (comparison > 0) {
					return 1;
				}
				
				return 0;
			}

			public String toString() {
				return packetText;
			}
		}
	}


}
