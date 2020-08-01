import Data.List.Split

main :: IO()
main = do
  contents <- getContents
  let l = read ((splitOn "\n" contents) !! 0) :: Int
  let d = read ((splitOn "\n" contents) !! 1) :: Int
  let x = read ((splitOn "\n" contents) !! 2) :: Int
  let minInt = minimumInt l x
  putStrLn ("" ++ (show (minimumInt l x)) ++ "\n" ++ (show (maximumInt d x)))

minimumInt :: Int -> Int  -> Int
minimumInt l x
  | (sumOfDigits l) == x = l
  | otherwise = minimumInt (l+1) x

maximumInt :: Int -> Int -> Int
maximumInt d x
  | (sumOfDigits d) == x = d
  | otherwise = maximumInt (d-1) x

sumOfDigits :: Int -> Int
sumOfDigits x
  | x == 0 = 0
  | otherwise = (x `mod` 10) + (sumOfDigits (x `div` 10))
