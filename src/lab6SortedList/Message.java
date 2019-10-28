package lab6SortedList;

public class Message{
	String msg;

	public Message() {
		this("");
	}

	public Message(String s) {
		msg = s;
	}

	public Packet[] encode() {
		int size = msg.length()/3;
		if(size % 3 != 0) {
			size++;
		}
		Packet[] p = new Packet[size];
		int sNum = 0;
		String s = "" + sNum;
		for(int i = 0; i < msg.length(); i++) {
			if(i == msg.length() - 1) {

			} else if(i != 0 && i % 3 == 0) {
				p[sNum] = new Packet(s);
				s = sNum + " ";
			} else {
				s+=s.substring(0,1);
				s = s.substring(1,msg.length());
			}
		}

		p = scramble(p);		
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

	public Packet[] decode(Packet[] p) { //will use insertion sort


		return p;
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
				} else if ( comparison> 0) {
					return 1;
				}
			}
			
			return 0;
		}
	}

}



