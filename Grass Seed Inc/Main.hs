import Data.List.Split

main :: IO()
main = do
  contents <- getContents
  let eachLine = splitOn "\n" contents
  let cost = read (eachLine !! 0) :: Double
  let result = (calculateCost (tail (tail (init eachLine)))) * cost
  putStrLn (show result)

calculateCost :: [String] -> Double
calculateCost [] = 0.0
calculateCost (x:xs) = (read ((splitOn " " x) !! 0) :: Double) * (read ((splitOn " " x) !! 1) :: Double) + calculateCost xs
