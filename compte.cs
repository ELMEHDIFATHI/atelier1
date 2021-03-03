using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace compte_persone
{
    class compte
    {


        private int numcompte;
        private static int cmp = 0;
        private int solde;
        private static int max_plafond = 10000;
        private personne p;

        public compte(int s,personne p)
        {
            this.numcompte = ++cmp;
            this.solde = s;
            this.p = p;
        }

        public compte(int s)
        {
            this.numcompte = ++cmp;
            this.solde = s;
        }

        public void afficher1()
        {
            Console.WriteLine("numero compte est:"+this.numcompte+"solde est :"+this.solde);
        }

        public void print()
        {
            Console.WriteLine("numero compte est:" + this.numcompte + "solde est :" + this.solde);
            this.p.afficher();
        }
        public void ajouter_solde(int valeur)
       
        {
            if (valeur > 0)
            {
                this.solde += valeur;
            }
            else
            {
                Console.Write("entre une valeur superieur");
            }

        }


        public void retire_solde(int valeur)
        {
            if (valeur > 0 && valeur<compte.max_plafond && valeur<this.solde)
            {
                this.solde -= valeur;
            }
            else
            {
                Console.Write("impossible de retrait le solde de ce compte");
            }

        }

        public static void virement(compte p1,compte p2,int valeur) {
            p1.retire_solde(valeur);
            p2.ajouter_solde(valeur);

        }



    }
}
