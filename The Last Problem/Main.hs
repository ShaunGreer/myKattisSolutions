import Data.List.Split

main :: IO()
main = do
  name <- getContents
  putStrLn ("Thank you, " ++ (init name) ++ ", and farewell!")
