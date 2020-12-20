import Data.List.Split

table :: [(Char, Int, Int)]
table = [
  ('A', 11, 11),
  ('K', 4, 4),
  ('Q', 3, 3),
  ('J', 20, 2),
  ('T', 10, 10),
  ('9', 14, 0),
  ('8', 0, 0),
  ('7', 0, 0)
  ]

main :: IO()
main = do
  contents <- getContents
  let asList = splitOn "\n" contents
  let n = (splitOn " " (asList !! 0) !! 0)
  let b = (splitOn " " (asList !! 0) !! 1)
  let result = calculate (tail (init asList)) (b !! 0)

  putStrLn (show result)

calculate :: [String] -> Char -> Int
calculate [] b = 0
calculate (x:xs) b
  | (x !! 1) == b = (getDomValue (x!!0) 0) + calculate xs b
  | otherwise = (getNonDomValue (x!!0) 0) + calculate xs b

getDomValue :: Char -> Int -> Int
getDomValue c i
  | c == (firstElement (table !! i)) = middleElement (table !! i)
  | otherwise = getDomValue c (i + 1)


getNonDomValue :: Char -> Int -> Int
getNonDomValue c i
  | c == (firstElement (table !! i)) = lastElement (table !! i)
  | otherwise = getNonDomValue c (i + 1)

firstElement :: (Char, Int, Int) -> Char
firstElement (c, _, _) = c

middleElement :: (Char, Int, Int) -> Int
middleElement (_, x, _) = x

lastElement :: (Char, Int, Int) -> Int
lastElement (_, _, x) = x
