#include <stdio.h>
#include <iostream>
#include <fstream>
#include <string>
#include <vector>
#include <cmath>
#include <algorithm>

std::vector<std::string> createPuzzleVector(std::fstream&);
int part1();
int part2();


int main(int argc, char const *argv[])
{

    std::cout << part1() << std::endl;
    std::cout << part2() << std::endl;
    return 0;
}

int part1(){
    std::fstream file;
    file.open("puzzledata.txt", std::ios::in);
    std::vector<std::string> puzzleVector = createPuzzleVector(file);
    file.close();

    int currentMax = -1;
    int calorieSum = 0;
    for(int i = 0; i < puzzleVector.size(); ++i)
    {
        if(puzzleVector[i] == ""){
            currentMax = std::fmax(currentMax, calorieSum);
            calorieSum = 0;
            continue;
        }

        calorieSum += std::stol (puzzleVector[i]);

    }    
    return currentMax;
}


int part2(){
    std::fstream file;
    file.open("puzzledata.txt", std::ios::in);
    std::vector<std::string> puzzleVector = createPuzzleVector(file);
    file.close();

    std::vector<int> calories;
    int calorieSum = 0;
    for(int i = 0; i < puzzleVector.size(); ++i)
    {
        if(puzzleVector[i] == ""){
            calories.push_back(calorieSum);
            calorieSum = 0;
            continue;
        }

        calorieSum += std::stol (puzzleVector[i]);

    }



    std::sort(calories.begin(), calories.end());
    int calorieEnd = calories.size();
    int sum = 0;
    for(int i = calorieEnd-1; i > calorieEnd-4; --i){
        sum += calories[i];
    }
    return sum;
}


std::vector<std::string> createPuzzleVector(std::fstream& file){
    std::vector<std::string> puzzleVector;

    if(file.is_open())
    {
        std::string line;
        while(getline(file, line))
        {
            puzzleVector.push_back(line);
        }
    }

    return puzzleVector;
}
