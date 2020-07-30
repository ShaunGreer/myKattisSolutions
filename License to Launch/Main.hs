import Data.List.Split
import Data.List

main :: IO()
main = do
  contents <- getContents
  let spaceJunk = splitOn " " ((splitOn "\n" contents) !! 1)
  putStrLn (show (maybeToInt (bestLaunchDay spaceJunk)))

bestLaunchDay :: [String] -> Maybe Int
bestLaunchDay spaceJunk = elemIndex (minimum (toInt spaceJunk)) (toInt spaceJunk)

maybeToInt :: Maybe Int -> Int
maybeToInt (Just x) = x

toInt :: [String] -> [Int]
toInt [] = []
toInt (x:xs) = (read x :: Int) : toInt xs
