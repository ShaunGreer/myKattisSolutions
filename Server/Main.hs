import Data.List.Split(splitOn)

main::IO()
main = do
  contents <- getContents
  let t = read ((splitOn " " ((splitOn "\n" contents) !! 0)) !! 1) :: Int
  let tasks = splitOn " " ((splitOn "\n" contents) !! 1)
  putStrLn (show (completedTasks t tasks 0))

completedTasks :: Int -> [String] -> Int -> Int
completedTasks _ [] total = total
completedTasks t (x:xs) total
  | (t - (read x :: Int)) < 0 = total
  | otherwise = completedTasks (t - (read x :: Int)) xs (total + 1)
