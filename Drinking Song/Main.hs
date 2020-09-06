import Data.List.Split(splitOn)
main = do
  contents <- readFile "1.in"
  let bottles = read ((splitOn "\n" contents) !! 0) :: Int
  let typeOfBottle = (splitOn "\n" contents) !! 1
  printSong (song bottles typeOfBottle)

printSong :: [String] -> IO()
printSong [] = return()
printSong [x] = putStrLn (x)
printSong (x:xs) = do
  putStrLn (x ++ "\n")
  printSong xs

song :: Int -> String -> [String]
song n bottle
  | n == 0 = []
  | n == 1 = ("1 bottle of " ++ bottle ++ " on the wall, 1 bottle of "
    ++ bottle ++ ".\nTake it down, pass it around, no more bottles of "
    ++ bottle ++ ".") : song (n-1) bottle
  | n == 2 = ("2 bottles of " ++ bottle ++ " on the wall, 2 bottles of "
    ++ bottle ++ ".\nTake one down, pass it around, 1 bottle of "
    ++ bottle ++ " on the wall.") : song (n-1) bottle
  | otherwise = ((show n) ++ " bottles of " ++ bottle ++ " on the wall, "
    ++ (show n) ++ " bottles of " ++ bottle ++ ".\nTake one down, pass it around, "
    ++ (show (n-1)) ++ " bottles of " ++ bottle ++ " on the wall.") : song (n-1) bottle
