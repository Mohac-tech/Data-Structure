//import java.lang.*;

package test;

interface appelable{	
	String fonction (String element);
}

class chaine {

	// declaration des racine des structure de donnees
	private static Noeud racine = new Noeud();
    private NoeudP tete = new NoeudP();
    private NoeudF debut = new NoeudF();
    private NoeudF fin = new NoeudF();
    private NoeudTas racineTas = new NoeudTas();

	// Construteur;
    chaine()
   {
       racine = null;
       tete = null;
       debut = null;
       fin = null;
       racineTas = null;
   }   
    
  //***********************************Question 1***************************************************        
    // insertion dans la chiane de caractere
    void inserer(String elt, int index)
    {	
 
    	Noeud temp = new Noeud();
    	temp.donnee = elt;
    	temp.suivant = null;
    	
    	Noeud curseur = new Noeud(); 
     	
// on verifie ici si c'est a la racine qu'on veut faire l'insertion.
    	
       	if(index == 0)
    	{
         	 temp.suivant = racine;
         	 racine = temp;
         	 temp = null; 
    	}
// Sinon.
    	else
    	{
        	int num = 1;
            curseur = racine;
 // Dans le cas ou l'index de l'element a inserer n'est pas egale a la racine et que la chaine soit vide on ne peut pas faire d'insertion           
            if(racine == null) { System.out.println("Le chiffre "+ index +" ne peut etre inserer"); return;}
         
            while(curseur.suivant != null)
            {
// Ici on fait la recherche une recherche Si on a un index qui ne suit pas consecutivement l'index du dernier element dans la chaine on ne fait pas 
// l'insertion sinon on fait l'insertion            	
            	if(num == index)
            	{
            		temp.suivant = curseur.suivant;
            		curseur.suivant = temp;
            		temp = null;
            		return;
            	}
            	curseur = curseur.suivant;
            	num++;
            }            
            if(num==index)
              {
            	curseur.suivant = temp;
            	temp = null;
              } 
            else System.out.println("La position "+ index +" n'existe pas ");
            
    	}
    }
    
    void retirer(String element)
    {
    	  Noeud curseur = new Noeud();// le pointeur qui suit le pointeur qui fait la recherche de l'element a enlever
    	  Noeud curseur1 = new Noeud();// Le pointeur qui fait la recherche de l'element a enlever
    	  
    	  
    	  if((racine.donnee.compareTo(element) == 0)  && racine.suivant != null)
    	  {
    		  racine = racine.suivant;
    		  return;
    	  }
    	  else if(racine.donnee.compareTo(element) == 0){ 
    		   racine = null;
    		   return;
    	  } else {
    		  {
    	  }
    		  curseur = racine;
    		  curseur1 = racine.suivant;
   // Les pointeur curseur et curseur1 se suivent donc si on repere l'element a supprimer on fait la liaison entre l'element 
   // Qui le precede et l'element qui le suit (L'element supprimer) 		  
    		  while(curseur.suivant != null)
    		  {
    			  while(curseur1.suivant != null)
    			  {
    				  if(curseur1.donnee == element)
    				  {
    					  break;
    				  } 
    				  curseur1 = curseur1.suivant;
    			  }
    			  if(curseur.suivant == curseur1)
    			  {
    				  curseur.suivant = curseur1.suivant;
    				  curseur1 = null;
    				  
    				  break;
    			  } 
    			  curseur = curseur.suivant;
    		  }  
    		  
    		  curseur = null;  
    	  }
    	  
    }
    
    void retirer(String element, int index)
    {
      Noeud curseur = new Noeud();
      Noeud curseur1 = new Noeud();
// Si l'index rechercher et la donnee correspondent a la racine on fait la suppression sinon non      
      if(index == 0 && racine.donnee.compareTo(element) == 0 && racine.suivant != null)
      {
    	  curseur = racine;
		  racine = racine.suivant;
		  curseur = null;
		  return;
      }
      else {
    	  int num = 1;
    	  curseur = racine;
    	  curseur1 = racine.suivant;
// Si l'index rechercher et la donnee correspondent on fait la suppression sinon non    	  
    	  while(curseur.suivant != null)
    	  {
    		  if(num == index && curseur.suivant.donnee.compareTo(element) == 0)
    		  {
    			  curseur1 = curseur.suivant;
    			  curseur.suivant = curseur1.suivant;
    			  curseur1 = null;
    			  
    			  break;
    		  }
    		  
    		  num++;
    		  curseur = curseur.suivant;
    	  }
      }
    }
    
    void afficher()
    {
    	Noeud parc = new Noeud();	
    	parc = racine;
    	
    	if(racine == null)
    	{
    		System.out.println("La chaine est vide");
    	}
    	
    	while(parc != null)
    	{
    		System.out.println(parc.donnee);
    		parc = parc.suivant;
    	}
    }
    
//****************************************Methode Pile*******************************************/
    
    void push(String element)
    {
    	NoeudP temporaire = new NoeudP();
    	temporaire.donnee = element;
    	temporaire.suivant = null;
 // si on fait la pile est null on fait l'insertion a la racine sinon on fait toujours l'insertion a la racine en considerant les elements deja present   	
    	if(tete == null)
    	{
    		tete = temporaire;
    		temporaire = null;
    	}
    	else
    	{
    		temporaire.suivant = tete;
    		tete = temporaire;
    		temporaire = null;
    	}
    }
// On fait la suppresion a la tete    
    String pop()
    {
    	NoeudP temporaire = new NoeudP();
    	
    	if(tete == null) {return null;}
    	
    	if(tete.suivant == null)
    	{
    		temporaire = tete;
   		    tete = null;
    		return temporaire.donnee;
    	}
    	
    	temporaire = tete;
    	tete = tete.suivant;
    	
    	return temporaire.donnee;
    }
    
    void afficher1()
    {
    	NoeudP parc = new NoeudP();	
    	parc = tete;
    	
    	if(tete == null)
    	{
    		System.out.println("La chaine est vide");
    	}
    	else {
    	while(parc != null)
    	{
    		System.out.println(parc.donnee);
    		parc = parc.suivant;
    	}
    	}
    }
    
//*************************************************Methodes File**********************************************
    
    void pushF(String element)
    {
    	NoeudF temp = new NoeudF();
    	temp.donnee = element;
    	temp.suivant = null;
 // On effectue les insertions a la tete    	
    	if(debut == null)
    	{
    		debut = temp;
    		fin = temp;
    		temp = null;
    	}
    	else
    	{
    		temp.suivant = debut;
    	    debut = temp;
    		temp = null;
    	}
    }
// Les suppression se font a la queue (Fin)
    void pop_back()
    {
    	NoeudF curseur = new NoeudF();
    	curseur = debut;
    	
    	if(debut == fin)
    	{
    		debut = null;
    		fin = null;
    		return;
    	}
    	else
    	{
         	while(curseur.suivant != fin)
        	{
    	    	curseur = curseur.suivant;
        	}
     	
    		curseur.suivant = null;
    		fin = curseur;
    		
    	}
    }
    
    void afficher2()
    {
    	NoeudF parc = new NoeudF();	
    	parc = debut;
    	
    	if(debut == null)
    	{
    		System.out.println("La chaine est vide");
    	}
    	else {
    	while(parc != null)
    	{
    		System.out.println(parc.donnee);
    		
    		parc = parc.suivant;
    	}
    	}
    }

//*************************************************methodes tas********************************************** 
// On fait fait l'ajout a la racine et pour les autres insertion on fait la verification sur l'emplacement libre et on fait le balancement 
    void ajouter(String element)
    {
    	NoeudTas temporaire = new NoeudTas();
    	temporaire.donnee = element;
    	temporaire.gauche = null;
    	temporaire.droite = null;
    	
    	if(racineTas == null)
    	{
    		racineTas = temporaire;
    		temporaire = null;
    		return;
    	}
    	else
    	{
    		NoeudTas curseur = new NoeudTas();	
    		curseur = racineTas;
    		String conteneur; 
    		
    		if(racineTas.donnee.compareTo(element) == 0)
    		{
    			System.out.println(" Deja existant ");
    			return;
    		}
    		else 
    		{
    			if(curseur.gauche == null)
    		  {
    			curseur.gauche = temporaire;
    			if(element.compareTo(curseur.gauche.donnee) == 1 || element.compareTo(curseur.gauche.donnee) == 0)
    			{
    				NoeudTas echange = new NoeudTas();
    				
    				echange = curseur;
    				curseur = curseur.gauche;
    				curseur = echange;
    				
    				echange = null;
    				return;
    			}
    			else if(curseur.droite == null)
    			{
    				curseur.droite = temporaire;
    				
    				if(element.compareTo(curseur.droite.donnee) == 1 || element.compareTo(curseur.droite.donnee) == 0)
        			{
        				NoeudTas echange = new NoeudTas();
        				
        				echange = curseur;
        				curseur = curseur.droite;
        				curseur = echange;
        				
        				echange = null;
        				return;
        			}
    			}
    		}
    		}
    	}
    }
    
//***********************************Question 2***************************************************    
    
    static boolean verificateur(char Verif)
    {
    	switch(Verif)
    	{
    	  case '-':
    	  case '+':
    	  case '*':
    	  case '/':
    		  return true;
    	}
    	return false;
    }
    
    static String convertisseur(String conteneur)
    {
    	chaine A = new chaine();
    	
    	int Long = conteneur.length();
    	
    	for(int i = Long - 1; i >= 0; i--)
    	{
    		char c = conteneur.charAt(i);
    		if(verificateur(c))
    		{
    		
    		String operand = A.pop();
    		String operand_1 = A.pop();
    		
    		String M = "(" + operand + c + operand_1 + ")";
    		A.push(M);
    		}
    		else
    		{
    			A.push(c + "");
    		}
    	}
    	return A.pop();
    	}
//***********************************Question 3***************************************************    

    static void fonction_map(chaine A, appelable m)
    {
    	Noeud tempo = new Noeud();
        tempo = racine;
    	
    	while(tempo != null)
    	{
    		System.out.println(m.fonction(tempo.donnee));
    		tempo = tempo.suivant;
    	}
    }
    
//********************************************************************************************************    

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		System.out.println("Les elements de la chaine de caractere");
		chaine A = new chaine();
		
		A.inserer("caractere 1", 0);
		A.inserer("caractere 2", 1);
		A.inserer("caractere 3", 1);
		//A.inserer("caractere 4", 2);
		//A.inserer("caractere 5", 3);
		//A.inserer("caractere 6", 4);
		
		//A.retirer("caractere 1", 0);
		//A.retirer("caractere 3", 1);
		//A.retirer("Namaste 3", 1);
		A.retirer("car");
		
		A.afficher();
	
		/*
		System.out.println("La methode avec l'expression lambda ");
		fonction_map(A, x -> x.toUpperCase());
		
		System.out.println("Les elements de la pile");
		chaine B = new chaine();
		
		B.push("Element 1");
		B.push("Element 2");
		B.push("Element 2");
		
		B.pop();
		B.pop();
		B.afficher1();
		
		System.out.println("Les elements de la File");
		chaine C = new chaine();
		
		C.pushF("Donnee 1");
		C.pushF("Donnee 2");
		C.pushF("Donnee 3");
		C.pushF("Donnee 4");
		
		C.pop_back();
		C.pop_back();
		C.afficher2();
		
		System.out.println("Les elements du tas binaire");
	       
		chaine D = new chaine();
		D.ajouter("Premier");
		D.ajouter("deuxieme");
		D.ajouter("troisieme");
		
		
		System.out.println("Metode de converstion de infix a prefix");
		String exemple = "+AB ";
		System.out.println("Prefix : "+ exemple);
		System.out.println("Infix : " + convertisseur(exemple));
		String exemple1 = "*+ABC ";
		System.out.println("Prefix : "+ exemple1);
		System.out.println("Infix : " + convertisseur(exemple1));
		
	*/
	  
	}

}
