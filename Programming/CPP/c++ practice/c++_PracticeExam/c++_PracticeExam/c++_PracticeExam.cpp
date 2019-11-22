// c++_PracticeExam.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"
#include<iostream>
#include<string>
#include<cmath>
using namespace std;
static void uniqueElems()
{
	cout << "enter array length: ";
	int length;
	cin >> length;
	int* array = new int[length];
	for (int i = 0; i < length; i++){
		cin >> array[i];

}

	int max = array[0];
	for (int i = 1; i < length-1; i++){
		if (array[i] > max){
			max = array[i];
		}
	}

	for (int i = 0; i < length; i++){
		if (array[i] == max){
			array[i] *= 2;
		}
	}
	for (int i = 0; i < length; i++){
		cout << " " << array[i];
	}

}


int main()
{
	uniqueElems();

	return 0;
}

