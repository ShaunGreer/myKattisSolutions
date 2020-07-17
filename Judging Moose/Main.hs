import Data.List.Split

main :: IO()
main = do
  contents <- getContents
  let left = read ((splitOn " " contents) !! 0) :: Int
  let right = read ((splitOn " " contents) !! 1) :: Int
  printAns (checkAge left right)

checkAge :: Int -> Int -> (String, Int)
checkAge left right
  | left == 0 && right == 0 = ("Not a moose", (-1))
  | left == right = ("Even", (left + right))
  | otherwise = ("Odd", (max left right) * 2)

printAns :: (String, Int) -> IO()
printAns (name, num)
  | num == (-1) = putStrLn (name)
  | otherwise = putStrLn (name ++ " " ++ (show num))
