import Data.List.Split(splitOn)
import qualified Data.HashMap.Strict as Map

main::IO()
main = do
  contents <- getContents
  let votes = init (init (splitOn "\n" contents))
  putStrLn (highest (Map.toList (count votes (Map.fromList []))) 0 False "")

highest :: [(String, Int)] -> Int -> Bool -> String -> String
highest [] _ sameLargest candidate
  | sameLargest = "Runoff!"
  | otherwise = candidate
highest ((x,y):xs) largest sameLargest candidate
  | y == largest = highest xs largest True candidate
  | y > largest = highest xs y False x
  | otherwise = highest xs largest sameLargest candidate

count :: [String] -> Map.HashMap String Int -> Map.HashMap String Int
count [] c = c
count (x:xs) c
  | (Map.lookup x c) == Nothing = count xs (Map.insert x 1 c)
  | otherwise = count xs (Map.adjust (+1) x c)--Increase value
