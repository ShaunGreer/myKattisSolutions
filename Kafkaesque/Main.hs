import Data.List.Split (splitOn)

main::IO()
main = do
  contents <- getContents
  let deskNumbers = init (tail (splitOn "\n" contents))
  putStrLn (show (passes deskNumbers))

passes :: [String] -> Int
passes [] = 0
passes [x] = 1
passes (x:y:xs)
  | (read y :: Int) < (read x :: Int) = 1 + passes (y:xs)
  | otherwise = passes (y:xs)
