import Data.List.Split

main :: IO()
main = do
  content <- getContents
  let eachLine = splitOn "\n" content
  printSolution (controller eachLine)

controller :: [String] -> [String]
controller allLines
  | (calculate
    (read ((splitOn " " (allLines!!0)) !! 0) :: Int)
    (read ((splitOn " " (allLines!!0)) !! 1) :: Int)
    (read ((splitOn " " (allLines!!0)) !! 2) :: Int))
    == "end" = []
  | otherwise = (calculate
    (read ((splitOn " " (allLines!!0)) !! 0) :: Int)
    (read ((splitOn " " (allLines!!0)) !! 1) :: Int)
    (read ((splitOn " " (allLines!!0)) !! 2) :: Int))
    : controller (tail allLines)

calculate :: Int -> Int -> Int -> String
calculate 0 0 0 = "end"
calculate a b c
  | (max a (max b c)) == a = pythagoras b c a
  | (max a (max b c)) == b = pythagoras a c b
  | otherwise = pythagoras a b c

pythagoras :: Int -> Int -> Int -> String
pythagoras a b c
  | (a^2) + (b^2) == (c^2) = "right"
  | otherwise = "wrong"

printSolution :: [String] -> IO()
printSolution [] = return ()
printSolution (x:xs) = do
  putStrLn (x)
  printSolution xs
