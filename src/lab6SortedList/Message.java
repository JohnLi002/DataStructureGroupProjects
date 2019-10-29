package lab6SortedList;

public class Message{
	private String msg;
	private Packet[] p;

	public Message() {
		this("");
	}

	public Message(String s) {
		msg = s;
		encode();
	}

	public Packet[] encode() {
		int size = msg.length()/3;
		if(size % 3 != 0) {
			size++;
		}
		String original = msg;
		Packet[] p = new Packet[size];
		int sNum = 0;
		String s = sNum + " ";
		for(int i = 0; i < msg.length(); i++) {
			if(i != 0 && i % 3 == 0) {
				p[sNum] = new Packet(s);
				s = sNum + " ";
			} else {
				s+=original.substring(0,1);
				original = original.substring(1,msg.length());
			}
		}

		p = scramble(p);		
		return p;
	}
	
	public Packet[] getPacket() {
		return p;
	}

	private Packet[] scramble(Packet[] p) {
		for(int i = 0; i < p.length; i++) {
			Packet current = p[i];
			int random = (int) (Math.random()*p.length);
			Packet temp = p[random];
			p[random] = current;
			p[i] = temp;
		}

		return p;
	}

	public SortedLinkedList<Packet> decode(Packet[] p) { //will use insertion sort
		SortedLinkedList<Packet> s = new SortedLinkedList<>();
		
		for(int i = 0; i < p.length; i++) {
			s.add(p[i]);
		}
		
		return s;
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
			
			for(int i = 0; i < p.getPacketText().length(); i++) {
				int comparison = getPacketText().charAt(i) - p.getPacketText().charAt(i);

				if(comparison < 0) {
					return -1;
				} else if (comparison > 0) {
					return 1;
				}
			}
			
			return 0;
		}
		
		public String toString() {
			return packetText;
		}
	}
}



