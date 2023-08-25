public class Main{
	public static void main(String[] args) {
		Node<String> n1=new Node<String>("1",true,false);
		Node<String> n2=new Node<String>("2",false,false);
		Node<String> n3=new Node<String>("3",false,false);
		Node<String> n4=new Node<String>("4",false,false);
		Node<String> n5=new Node<String>("5",false,false);
		Node<String> n6=new Node<String>("6",false,false);
		Node<String> n7=new Node<String>("7",false,false);
		Node<String> n8=new Node<String>("8",false,false);
		Node<String> n9=new Node<String>("9",false,false);
		Node<String> n10=new Node<String>("10",false,true);
		Node<String> n11=new Node<String>("11",false,false);
		Node<String> n12=new Node<String>("12",false,false);
		Node<String> n13=new Node<String>("13",false,false);
		Node<String> n14=new Node<String>("14",false,false);
		Node<String> n15=new Node<String>("15",false,false);
		Node<String> n16=new Node<String>("16",false,true);

		n1.add(n2);
		n1.add(n3);
		n1.add(n7);
		n1.add(n4);
		n2.add(n9);
		n2.add(n8);
		n2.add(n5);
		n2.add(n9);
		n3.add(n7);
		n4.add(n11);
		n7.add(n11);
		n5.add(n6);
		n8.add(n9);
		n8.add(n15);
		n9.add(n14);
		//n6.add(n10);
		n6.add(n8);
		n6.add(n7);
		//n10.add(n16);
		n11.add(n12);
		//n11.add(n10);
		n14.add(n15);
		n15.add(n16);
		n12.add(n13);
		n13.add(n16);
		
		n1.print();

		Graph<String> g=new Graph<String>(n1);

		System.out.println("Longueur min : "+ g.minNoeud() +".");
		System.out.println("Longueur max : "+ g.maxNoeud() +".");

		g.parcoursProfondeur();
		g.parcoursLargeur();
	}
}