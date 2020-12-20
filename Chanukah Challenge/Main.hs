main :: IO()
main = do
  contents <- getContents
  printAnswer 1 $ chanukah $ tail $ toInt $ words contents

chanukah :: [Int] -> [Int]
chanukah [] = []
chanukah (k:n:rest) = ((getCandles n) + n) : chanukah rest

getCandles :: Int -> Int
getCandles 0 = 0
getCandles n = n + getCandles (n-1)

toInt :: [String] -> [Int]
toInt = map read

printAnswer :: Int -> [Int] -> IO()
printAnswer _ [] = return()
printAnswer i (x:xs) = do
  putStrLn $ show i ++ " " ++ show x
  printAnswer (i+1) xs
