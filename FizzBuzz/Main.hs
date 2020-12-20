import Data.List.Split

main :: IO()
main = do
  contents <- getContents
  let x = read ((splitOn " " contents) !! 0) :: Int
  let y = read ((splitOn " " contents) !! 1) :: Int
  let n = read ((splitOn " " contents) !! 2) :: Int
  calculate x y n 1

calculate :: Int -> Int -> Int -> Int -> IO()
calculate x y n c
  | c > n = return()
  | (c `mod` x == 0) && (c `mod` y == 0) = do
    putStrLn ("FizzBuzz")
    calculate x y n (c+1)
  | c `mod` x == 0 = do
    putStrLn ("Fizz")
    calculate x y n (c+1)
  | c `mod` y == 0 = do
    putStrLn ("Buzz")
    calculate x y n (c+1)
  | otherwise = do
    putStrLn (show c)
    calculate x y n (c+1)
