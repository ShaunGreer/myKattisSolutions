import Data.List.Split

main :: IO()
main = do
  input <- getContents
  let n = read input :: Int
  putStrLn (show (nextHarshad n))

nextHarshad :: Int -> Int
nextHarshad n
  | (isHarshad n) = n
  | otherwise = nextHarshad (n+1)

isHarshad :: Int -> Bool
isHarshad n = (n `mod` (sumOfDigits n)) == 0

sumOfDigits :: Int -> Int
sumOfDigits 0 = 0
sumOfDigits n = (n `mod` 10) + sumOfDigits (div n 10)
