import Data.List.Split

main :: IO()
main = do
  contents <- getContents
  let h = (read ((splitOn " " contents) !! 0) :: Int)
  let m = (read ((splitOn " " contents) !! 1) :: Int)
  printTime (calculate h m)

calculate :: Int -> Int -> [Int]
calculate h m
  | (m - 45) < 0 = innerCalc h m
  | otherwise = [h, (m - 45)]

innerCalc :: Int -> Int -> [Int]
innerCalc h m
  | (h-1) < 0 = [23, ((60-45) + m)]
  | otherwise = [(h-1), ((60-45) + m)]

printTime :: [Int] -> IO()
printTime [x,y] = putStrLn ((show x) ++ " " ++ (show y))
