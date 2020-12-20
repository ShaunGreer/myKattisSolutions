import Data.List.Split
import Data.List

main :: IO()
main = do
  contents <- getContents
  let eachLine = init (splitOn "\n" contents)
  let allSums = sumAll eachLine
  let highestScore = findHighest allSums
  let winner = (toInt (elemIndex highestScore allSums))
  putStrLn ((show (winner+1)) ++ " " ++(show highestScore))

toInt :: Maybe Int -> Int
toInt (Just n) = n

sumAll :: [String] -> [Int]
sumAll [] = []
sumAll (x:xs) = (read [(x!!0)] ::Int) +(read [(x!!2)] ::Int) + (read [(x!!4)] ::Int) + (read [(x!!6)] ::Int) :  sumAll xs

findHighest :: [Int] -> Int
findHighest [x] = x
findHighest (x:y:xs)
  | x > y = findHighest (x:xs)
  | otherwise = findHighest (y:xs)
