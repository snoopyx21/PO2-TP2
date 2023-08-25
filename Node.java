import java.util.*;

public class Node<E>{
	public Vector<Node<E>> links;
	public E elt;
	private boolean isSource;
	private boolean isPuit;
	private int nbNodeSuiv=0;
	//a parent pour trouver la source


	public Node(E a,boolean s, boolean p)
	{
		elt=a;
		links= new Vector<Node<E>>();
		isPuit=p;
		isSource=s;
	}
	
	public void add(Node<E> n)
	{
		//mettre a parent da true ici
		links.add(n);
		nbNodeSuiv++;
	}	

	public boolean isSource()
	{
		return isSource;
	}

	public boolean isPuit()
	{
		return isPuit;
	}

	public int nbNodeSuiv()
	{
		return nbNodeSuiv;
	}

	public void print(){
		System.out.println(this.toString());
	}
	
	public String toString(){
		return "" +elt+" ";
	}

	public int miNoeud()
	{
		if(isPuit)
			return 0;
		else
		{
			int nb=links.elementAt(0).miNoeud();
			for(int i=1;i<nbNodeSuiv;i++)
			{
				nb= Math.min(nb,links.elementAt(i).miNoeud());
			}
			return nb+1;
		}
	}

	public int maNoeud()
	{
		if(isPuit)
			return 0;
		else
		{
			int nb=links.elementAt(0).maNoeud();
			for(int i=1;i<nbNodeSuiv;i++)
			{
				nb= Math.max(nb,links.elementAt(i).maNoeud());
			}
			return nb+1;
		}
	}

}

/*
public class NODE <E>{
	//Attributes 
	protected Vector <NODE<E>> p_links;
	private E p_val;
	private String p_nom;
	private boolean p_gotParent;
	
	// Methods 
	public NODE(String a_nom, E a_val){
		p_links = new Vector<NODE<E>>();
		p_nom=a_nom;
		p_val=a_val;
		p_gotParent=false;
		System.out.print("Nouveau ");
		print();
	}
	public NODE add(NODE a_child){
		p_links.addElement(a_child);
		a_child.setTrue_gotParent();
		return a_child;
	}
	
	//	Utile pour l'objet Graph, et permet 
		de determier si un obj a un parent 
	public void setTrue_gotParent(){
		p_gotParent=true;
	}
	public boolean gotParent(){
		return p_gotParent;
	}

	// Debug 
	public String getName(){
		return p_nom;
	}
	public void print(){
		System.out.println(this.toString());
	}
	public String toString(){
		String linksPrint="";
		for(int i=0;i<p_links.size();i++){
			linksPrint+=p_links.elementAt(i).getName();
			if(i<p_links.size()-1)
				linksPrint+=",";
		}
		return "Node "+p_nom+" {val="+p_val+", gotParent="+
		p_gotParent+" links=["+linksPrint+"]}";
	}
}
*/