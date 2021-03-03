using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace compte_persone
{
    class personne
    {
        public personne(string n,string p,string a)
        {
            this.nom = n;
            this.prenom = p;
            this.adresse = a;

        }

        public void afficher()
        {
            Console.WriteLine("le nom est " + this.nom + "le prenom est :" + this.prenom + "l adresse est :" + this.adresse);
        }



        private string nom,prenom,adresse;  
    }
}
