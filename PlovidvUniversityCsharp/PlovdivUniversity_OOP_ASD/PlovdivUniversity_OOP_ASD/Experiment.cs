using System;
using System.Collections.Generic;
using System.Linq;
using System.Reflection.Metadata.Ecma335;
using System.Text;

namespace PlovdivUniversity_OOP_ASD
{
    class Experiment
    {

        public void CarRace()
        {
            Dictionary<string, int> currentStats = new Dictionary<string, int>();
            List<Car> currentRacers = new List<Car>();
            string enterCarData = Console.ReadLine();
            string[] data;
            while (!enterCarData.Equals("end"))
            {
                data = enterCarData.Split("->");
                if(!currentStats.ContainsKey(string.Concat(data[0]+" " + data[1])))
                {
                    currentStats.Add(string.Concat(data[0] + " " + data[1]), 0);
                    currentRacers.Add(new Car(data));
                }
                enterCarData = Console.ReadLine();
            }

        
            currentRacers.Sort((a,b)=>a.HorsePower.CompareTo(b.HorsePower));

            DetermineWinnerByPoints(currentRacers, currentStats);
           currentStats =  currentStats.OrderByDescending(a => a.Value).ToDictionary(a => a.Key, a => a.Value);
            foreach(var item in currentStats)
            {
                Console.WriteLine(item.Key + " " + item.Value);

            }

        }




        private void DetermineWinnerByPoints(List<Car> currentRacers, Dictionary<string, int> points)
        {
            currentRacers =  currentRacers.OrderByDescending(a => a.To100).ToList();
            for(int i = 0; i < currentRacers.Count; i++)
            {
                points[currentRacers[i].DriverNames] += 3 * i;
            }

            currentRacers = currentRacers.OrderByDescending(a => a.After100).ToList();
            for(int i = 0; i < currentRacers.Count; i++)
            {
                points[currentRacers[i].DriverNames] += i * 3;
            }
        }


    }





    internal class Car
    {
        private string nameOfDriver;
        private string brand;
        private int horsePower;
        private double weight;
        private int to100;
        private int after100;
        

        public Car(params string[] currentData)
        {
            this.DriverNames = currentData[0] + " " + currentData[1];

            this.Brand = currentData[2];
            this.Weight = double.Parse(currentData[3]);
            this.HorsePower = int.Parse(currentData[4]);
            this.To100 = 100;
            this.After100 = 101;
            this.ApplyBoost(currentData[5]);
           

        }

        public string DriverNames
        {
            get
            {
                return this.nameOfDriver;
            }
           private set
            {
                this.nameOfDriver = value;
            }
        }

        public string Brand
        {
            get
            {
                return this.brand;
            }
          private  set
            {
                this.brand = value;
            }
        }

       

        public int HorsePower
        {
            get
            {
                return this.horsePower;
            }
          private  set
            {
                this.horsePower = value;
            }
        }

        public double Weight
        {
            get
            {
                return this.weight;
            }
          private  set
            {
                this.weight = value;
            }
        }
        public int To100
        {
            get
            {
                return this.to100;

            }
            private set
            {
                this.to100 = 1 / (value) * 1000 / 2;
            }
        }

        public int After100
        {
            get
            {
                return this.after100;
            }

            private set
            {
                this.after100 = 1 / (value) * 1000;
            }
        }

        private void ApplyBoost(string currentBoost)
        {
            switch (currentBoost.ToLower())
            {
                case "do-100":

                    this.horsePower -= (this.horsePower / 100) * 30;
                    break;
                case "do-200":
                    this.horsePower -= (this.horsePower / 100) * 20;
                    break;
            }
        }

        public override string ToString()
        {
            return string.Format($"");
        }
    }
}
