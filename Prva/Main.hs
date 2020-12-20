import Data.List.Split
import Data.List

main::IO()
main = do
  contents <- getContents
  let eachRow = init (tail (splitOn "\n" contents))
  let horizontals = getEachHorizontalWord eachRow
  let verticals = filter (\x -> length x > 1) (splitHashes ((splitOn "0" ((getEachVerticalWord eachRow eachRow (length (eachRow !! 0)) 0)))))
  putStrLn ((sort (horizontals ++ verticals)) !! 0)

splitHashes :: [String] -> [String]
splitHashes [] = []
splitHashes (x:xs) = (splitOn "#" x) ++ splitHashes xs

getEachVerticalWord :: [String] -> [String] -> Int -> Int -> String
getEachVerticalWord [] full len i = '0' : getEachVerticalWord full full len (i+1)
getEachVerticalWord (x:xs) full len i
  | i == len = []
  | otherwise = (x!!i) : getEachVerticalWord xs full len i

getEachHorizontalWord :: [String] -> [String]
getEachHorizontalWord [] = []
getEachHorizontalWord (row:otherRows) = (filter (\x -> length x > 1) (splitOn "#" row)) ++ getEachHorizontalWord otherRows
