import Data.List.Split (splitOn)

main::IO()
main = do
  contents <- getContents
  let eachCase = init (tail (splitOn "\n" contents))
  let eachResult = lastFactorial eachCase
  printEachResult eachResult

printEachResult :: [Int] -> IO()
printEachResult [] = return()
printEachResult (x:xs) = do
  putStrLn (show x)
  printEachResult xs

lastFactorial :: [String] -> [Int]
lastFactorial [] = []
lastFactorial (x:xs) = (lastDigit (fac (read x :: Int))) : lastFactorial xs

fac :: Int -> Int
fac x
  | x == 0 || x == 1 = 1
  | otherwise = x * (fac (x - 1))

lastDigit :: Int -> Int
lastDigit x = x `mod` 10
