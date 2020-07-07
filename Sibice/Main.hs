import Data.List.Split

main :: IO()
main = do
  contents <- getContents
  let allLines = splitOn "\n" contents
  let line1 = (splitOn " " (allLines!!0))
  let n = (read (line1 !! 0) :: Int)
  let h  =(read (line1 !! 1) :: Int)
  let w = (read (line1 !! 2) :: Int)
  printAll (calculate (tail (init allLines)) h w)

calculate :: [String] -> Int -> Int -> [String]
calculate [] _ _ = []
calculate (x:xs) h w
  | ((read x :: Int) <= h) || ((read x :: Int) <= w) || (pythagoras (read x :: Int) h w) = "DA" : calculate xs h w
  | otherwise = "NE" : calculate xs h w

pythagoras :: Int -> Int -> Int -> Bool
pythagoras x h w
  | (x^2) <= ((h^2) + (w^2)) = True
  | otherwise = False

printAll :: [String] -> IO()
printAll [] = return ()
printAll (x:xs) = do
  putStrLn (x)
  printAll xs
