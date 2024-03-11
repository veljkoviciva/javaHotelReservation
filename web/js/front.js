
            function uporediDatume()
            {
                var pocetakRezervacije = document.getElementById("pocetakRezervacije").value;
                var krajRezervacije = document.getElementById("krajRezervacije").value;

                if ((new Date(krajRezervacije).getDay() > new Date(pocetakRezervacije).getDay()+10))
                {
                    // Your code here
                }
            }
