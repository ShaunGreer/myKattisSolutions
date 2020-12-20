import Data.List.Split (splitOn)

main :: IO()
main = do
  contents <- getContents
  let answers = (splitOn "\n" contents) !! 1
  let len = length answers
  let adriansAnswers = getAdrians len 0 0
  let brunosAnswers = getBrunos len 0 0
  let goransAnswers = getGorans len 0 0
  let results = controller adriansAnswers brunosAnswers goransAnswers answers
  putStrLn (show (maximum results))
  printWinners (findWinners results (maximum results) 0)

printWinners :: [String] -> IO()
printWinners [] = return()
printWinners (x:xs) = do
  putStrLn (x)
  printWinners xs

findWinners :: [Int] -> Int -> Int -> [String]
findWinners results highest i
  | i ==  3 = []
  | i == 0 && (results !! i) == highest = "Adrian" : findWinners results highest (i+1)
  | i == 1 && (results !! i) == highest = "Bruno" : findWinners results highest (i+1)
  | i == 2 && (results !! i) == highest = "Goran" : findWinners results highest (i+1)
  | otherwise = findWinners results highest (i+1)

controller :: String -> String -> String -> String -> [Int]
controller a b g ans = (match a ans) : (match b ans) : (match g ans) : []

match :: String -> String -> Int
match [] [] = 0
match (x:xs) (y:ys)
  | x == y = 1 + match xs ys
  | otherwise = match xs ys

getGorans :: Int -> Int -> Int -> String
getGorans x y totalLen
  | totalLen == x = []
  | y == 6 = getGorans x 0 totalLen
  | y == 0 = 'C' : getGorans x (y+1) (totalLen + 1)
  | y == 1 = 'C' : getGorans x (y+1) (totalLen + 1)
  | y == 2 = 'A' : getGorans x (y+1) (totalLen + 1)
  | y == 3 = 'A' : getGorans x (y+1) (totalLen + 1)
  | y == 4 = 'B' : getGorans x (y+1) (totalLen + 1)
  | otherwise = 'B' : getGorans x (y+1) (totalLen + 1)

getBrunos :: Int -> Int -> Int -> String
getBrunos x y totalLen
  | totalLen == x = []
  | y == 4 = getBrunos x 0 totalLen
  | y == 0 || y == 2 = 'B' : getBrunos x (y+1) (totalLen + 1)
  | y == 1= 'A' : getBrunos x (y+1) (totalLen + 1)
  | otherwise = 'C' : getBrunos x (y+1) (totalLen + 1)

getAdrians :: Int -> Int -> Int -> String
getAdrians x y totalLen
  | totalLen == x = []
  | y == 3 = getAdrians x 0 totalLen
  | y == 0 = 'A' : getAdrians x (y+1) (totalLen + 1)
  | y == 1 = 'B' : getAdrians x (y+1) (totalLen + 1)
  | otherwise = 'C' :getAdrians x (y+1) (totalLen + 1)
