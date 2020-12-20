import Data.List.Split

main :: IO()
main = do
  contents <- getContents
  let n = read ((splitOn "\n" contents) !! 0) :: Int
  let before = (splitOn "\n" contents) !! 1
  let after = (splitOn "\n" contents) !! 2
  if (n `mod` 2) == 0
    then putStrLn (compareEqual before after)
    else putStrLn (compareOpposite before after)

compareEqual :: String -> String -> String
compareEqual [] [] = "Deletion succeeded"
compareEqual (x:xs) (y:ys)
  | (x == y) = compareEqual xs ys
  | otherwise = "Deletion failed"

compareOpposite :: String -> String -> String
compareOpposite [] [] = "Deletion succeeded"
compareOpposite (x:xs) (y:ys)
  | (x /= y) = compareOpposite xs ys
  | otherwise = "Deletion failed"
