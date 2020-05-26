using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace PlovdivUniversity_OOP_ASD
{
    class ASD_Tasks
    {


        public void RepeatenceWords()
        {
            string enterText = Console.ReadLine();
            string[] currentWords = enterText.Split();
            Dictionary<string, int> currentWordsCount = new Dictionary<string, int>();
            foreach(var item in currentWords)
            {
                if (!currentWordsCount.ContainsKey(item.ToLower()))
                {
                    currentWordsCount.Add(item, 1);
                }
                else
                {
                    currentWordsCount[item.ToLower()] += 1;
                }
            }
            currentWordsCount = currentWordsCount.Where(e => e.Value % 2 != 0).ToDictionary(e => e.Key, e => e.Value);
            foreach(var item in currentWordsCount)
            {
                Console.WriteLine(item.Key);
            }
        }

        public void MatrixMinElements()
        {
            int[,] currentMatrix = new int[5, 5];
            
            string addNumbers;
            for(int i = 0; i < 5; i++)
            {
                addNumbers = Console.ReadLine();
                for(int j = 0; j < 5; j++)
                {
                    FixNumberAdding()
                }
            }
        }
        private  void FixNumberAdding(string addedNumbers,int[] currentRow)
        {
            Random rand = new Random();
            int[] current = addedNumbers.Split().Select(e=>int.Parse(e)).ToArray();
            int[] numbersLine = new int[5];
            if (current.Length > 5)
            {
                Array.Copy(current, numbersLine, 5);
            }
            else if (current.Length < 5)
            {
                int neededNumbersToAdd = 5 - current.Length;
                
                Array.Copy(current, numbersLine, current.Length);
                for(int i = current.Length; i <= neededNumbersToAdd+1; i++)
                {
                    numbersLine[i] = rand.Next(0, int.MaxValue);
                }
            }
            else if (current.Length == 1)
            {
                numbersLine[0] = current[0];
                for(int i = 1; i < numbersLine.Length; i++)
                {
                    numbersLine[i] = rand.Next(1, int.MaxValue);
                }
            }
            else if (current.Length == 5)
            {
                
            }
            else
            {
                for (int i = 0; i < numbersLine.Length; i++)
                {
                    currentRow[i] = rand.Next(1, int.MaxValue);
                }
            }

            return numbersLine;
        }

    }
}
