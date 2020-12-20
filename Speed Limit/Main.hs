import Data.List.Split

main :: IO()
main = do
  contents <- getContents
  let allLines = splitOn "\n" contents
  let result = controller (init allLines) 0
  printDist result

--Returns (-1) if end of calculations
controller :: [String] -> Int -> [Int]
controller allLines counter
  | (read (allLines !! counter) :: Int) == (-1) = []
  | otherwise =
    (calculate (getWorkingLines allLines ((read (allLines !! counter) :: Int) + counter) (counter + 1)) 0)
    : (controller allLines (counter + (read (allLines !! counter) :: Int) + 1))

getWorkingLines :: [String] -> Int -> Int -> [Int]
getWorkingLines allLines index counter
  | counter > index = []
  | otherwise = (read ((splitOn " " (allLines !! counter)) !! 0) :: Int)
    : (read ((splitOn " " (allLines !! counter)) !! 1) :: Int)
    : (getWorkingLines allLines index (counter + 1))

calculate :: [Int] -> Int -> Int
calculate [] _ = 0
calculate (x:y:xs) elapsed = (x * (y - elapsed)) + (calculate xs y)

printDist :: [Int] -> IO()
printDist [] = return ()
printDist (x:xs) = do
   putStrLn ((show x) ++ " miles")
   printDist xs
