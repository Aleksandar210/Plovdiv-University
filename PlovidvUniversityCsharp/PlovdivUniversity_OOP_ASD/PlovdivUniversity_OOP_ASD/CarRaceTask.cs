using System;
using System.Collections.Generic;
using System.Linq;
using System.Reflection.Metadata.Ecma335;
using System.Text;

namespace PlovdivUniversity_OOP_ASD
{
    class CarRaceTask
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



        }


        public void WordOddRepeatence()
        {
            Dictionary<string, int> wordRepeatence = new Dictionary<string, int>();
            string enterText = Console.ReadLine();
           string[] allWords = enterText.Split().Select(e => e.ToLower()).ToArray();
            foreach(var item in allWords)
            {
                if (!wordRepeatence.ContainsKey(item))
                {
                    wordRepeatence.Add(item, 0);
                }
                else
                {
                    wordRepeatence[item]++;
                }
            }

            Dictionary<string, int> currentOddRepeatedWords = wordRepeatence.Where(e => e.Value % 2 != 0)
                .ToDictionary(e => e.Key, e => e.Value);
            foreach(var item in currentOddRepeatedWords)
            {
                Console.Write(item + " ");

            }
        }
    }





    internal class Car
    {
        private string nameOfDriver;
        private string brand;
        private int horsePower;
        private double weight;
        private double to100;
        private double after100;
        
        

        public Car(params string[] currentData)
        {
            this.DriverNames = currentData[0] + " " + currentData[1];

            this.Brand = currentData[2];
            this.Weight = double.Parse(currentData[3]);
            this.HorsePower = int.Parse(currentData[4]);
            this.To100 = CalculateSecondsTo100(this.HorsePower);
            this.After100 = CalculateSecondsAfter100(this.HorsePower);
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
        public double To100
        {
            get
            {
                return this.to100;

            }

            private set
            {

            }
            
        }

        private double CalculateSecondsTo100(int horsePower)
        {
            return ((1 / (double)horsePower) * 1000) / 2;
        }

        public double After100
        {
            get
            {
                return this.after100;
            }

            private set
            {

            }
           
        }

        private double CalculateSecondsAfter100(int horsePower)
        {
            return (1 / (double)horsePower) * 1000;
        }

        private void ApplyBoost(string currentBoost)
        {
            switch (currentBoost.ToLower())
            {
                case "do-100":

                    this.To100 =  this.To100 - ((this.To100 * 30) / 100);
                    break;
                case "do-200":
                    this.After100 = this.After100 - ((this.After100 * 20) / 100);
                    break;
            }
        }

        public override string ToString()
        {
            return string.Format($"");
        }
    }
}
