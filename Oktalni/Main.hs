import Data.List.Split(splitOn)

main::IO()
main = do
  let dictionary = [("000",'0'), ("001",'1'), ("010",'2'), ("011",'3'), ("100",'4'), ("101",'5'), ("110",'6'), ("111",'7')]
  contents <- getContents
  let input = (splitOn "\n" contents) !! 0
  if (length input) `mod` 3 == 0
    then putStrLn (getOctal input dictionary)
    else putStrLn (getOctal (pad input) dictionary)

getOctal :: String -> [(String, Char)] -> String
getOctal [] _ = []
getOctal x dictionary = (find (take 3 x) dictionary) : getOctal (drop 3 x) dictionary

find :: String -> [(String, Char)] -> Char
find y ((a,b):xs)
  | y == a = b
  | otherwise = find y xs

pad :: String -> String
pad x
  | (length x) `mod` 3 == 0 = x
  | otherwise = pad ('0' : x)
