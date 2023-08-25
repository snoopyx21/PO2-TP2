import java.util.*;
import java.util.Set;
import java.util.HashSet;


public class Graph<E> {
	//une seule source
	public Node<E> src;

	public Graph(Node<E> node)
	{
		src=node;
	}

	public int minNoeud()
	{
		return src.miNoeud();
	}

	public int maxNoeud()
	{
		return src.maNoeud();
	}

	class Profondeur<E>{
		public Vector<Node<E>> v;
		private int ite;
		//public Node<E> node;

		public Profondeur(Vector<Node<E>> v)
		{
			this.v=v;
			ite=-1;
			//node=v.elementAt(0);
		}	
		public void restart()
		{
			ite=-1;
		}

		public boolean hasNext()
		{
			if(ite<v.size()-1)
				return true;
			else
				return false;
		}		

		public Node<E> next()
		{
			ite++;
			return v.elementAt(ite);
		}	
	}


	private Vector<Node<E>> parcoursProfondeur(Node<E> origine, Vector<Node<E>> sommetsVisités) {
    	sommetsVisités.add(origine);
    	Graph<E>.Profondeur<E> p =new Graph<E>.Profondeur<E>(origine.links);
  		while (p.hasNext()) { 
      		Node<E> suivant = p.next();
      		if (!sommetsVisités.contains(suivant)) {
        		parcoursProfondeur(suivant, sommetsVisités);
      		}
    	}
    	return sommetsVisités;
  	}


  	public void parcoursProfondeur() {
      	
      	Vector<Node<E>> sommetsVisités = new Vector<Node<E>>();
        sommetsVisités=parcoursProfondeur(src, sommetsVisités);
        String affi="";
        for(int i=0;i<sommetsVisités.size();i++)
        {
        	affi+=sommetsVisités.elementAt(i).toString()+", ";
        }
        System.out.println(affi);

    }

	class Largeur<E>{
		public Vector<Node<E>> v;
		
    	public Largeur()
		{
			v=new Vector<Node<E>>();
		}	
		
		public Node<E> defiler()
		{
			return v.remove(0);
		}

		public void enfiler(Node<E> node)
		{
			v.add(node);
		}

		public boolean isEmpty()
		{
			return v.isEmpty();
		}
		public boolean contain(Node<E> node)
		{
			return v.contains(node);
		}
	}

    public void parcoursLargeur()
    {
    	String affi="";
    	Graph<E>.Largeur<E> p=new Graph<E>.Largeur<E>();
    	Graph<E>.Largeur<E> f=new Graph<E>.Largeur<E>();
    	p.enfiler(src);
    	f.enfiler(src);
    	while(!p.isEmpty())
    	{
    		Node<E> node=p.defiler();
    		affi+=" " +node.toString()+",";
    		Graph<E>.Profondeur<E> c=new Graph<E>.Profondeur<E>(node.links);
    		while(c.hasNext())
    		{
    			Node<E> node1=c.next();
    			if(!p.contain(node1) && !f.contain(node1))
    			{
    				f.enfiler(node1);
    				p.enfiler(node1);
    			}		
    		}
    	}
    	System.out.println(affi);
    }


}